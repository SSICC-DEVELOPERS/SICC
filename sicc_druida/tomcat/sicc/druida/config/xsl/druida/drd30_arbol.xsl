<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    ARBOL    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="ARBOL" mode="head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3arbol.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   <!--   estilo  -->
   <xsl:template match="ARBOL" mode="estilo">
      <xsl:choose>
         <xsl:when test="@scroll and @scroll='N'">
            <xsl:text>#</xsl:text>
            <xsl:value-of select="@nombre"/>Scroll{position:absolute; overflow: hidden; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/>; layer-background-color: <xsl:value-of select="@colorf"/>; background-color: <xsl:value-of select="@colorf"/>
            <xsl:text>}&#xa;</xsl:text>
            <!--
            <xsl:call-template name="CAPAestilo">
               <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
               <xsl:with-param name="visibilidad">visible</xsl:with-param>
               <xsl:with-param name="colborde"></xsl:with-param>
               <xsl:with-param name="padding"></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
               <xsl:with-param name="zindex">0</xsl:with-param>
               <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
               <xsl:with-param name="imagen"></xsl:with-param>
               <xsl:with-param name="repeat"></xsl:with-param>
            </xsl:call-template>
            -->
         </xsl:when> 
         <xsl:otherwise>
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
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>


   <!--   init  -->
   <xsl:template match="ARBOL" mode="init">
      <xsl:choose>
         <xsl:when test="@multisel and @multisel='S'">
            <xsl:text>arbol('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','0');</xsl:text>
            <xsl:text>arbol('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','@');</xsl:text>
         </xsl:when> 
         <xsl:otherwise>
            <xsl:text>arbolM('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','0');</xsl:text>
            <xsl:text>arbolM('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','@');</xsl:text>
            <xsl:text>arbolM('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','O','0');</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>


   <!--   script  -->
   <xsl:template match="ARBOL" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
      <xsl:variable name="arbolscroll">
         <xsl:value-of select="concat(@nombre,'Scroll')"/>
      </xsl:variable>


      <xsl:text>&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>=new Object();&#10;</xsl:text>

      <xsl:value-of select="@nombre"/><xsl:text>.imgs=new Array();&#10;</xsl:text>

      <xsl:value-of select="@nombre"/><xsl:text>.nsdoc='</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.vsb='</xsl:text><xsl:value-of select="@visibilidad"/><xsl:text>';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.bgcolor='</xsl:text><xsl:value-of select="@colorf"/><xsl:text>';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.oncolor='</xsl:text><xsl:value-of select="@oncolor"/><xsl:text>';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.overcolor='</xsl:text><xsl:value-of select="@overcolor"/><xsl:text>';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.idoff='</xsl:text><xsl:value-of select="@id"/><xsl:text>';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.id='</xsl:text><xsl:value-of select="@id"/><xsl:text>';&#10;</xsl:text>
      <xsl:if test="@padreSeleccionable and @padreSeleccionable='S'">
         <xsl:value-of select="@nombre"/><xsl:text>.padreselecc=true;&#xa;</xsl:text>
      </xsl:if>
      <xsl:value-of select="@nombre"/><xsl:text>.multiseleccion=</xsl:text>
      <xsl:choose>
        <xsl:when test="@multisel and @multisel='S'">true</xsl:when>
        <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>;&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.selecvisible=</xsl:text>
      <xsl:choose>
        <xsl:when test="@selecvisible and @selecvisible='S'">true</xsl:when>
        <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>;&#10;</xsl:text>

      <xsl:value-of select="@nombre"/><xsl:text>.ultima='.';&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.E=new Vector();&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.TC='Arbol';&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.ancho=</xsl:text><xsl:value-of select="@ancho"/><xsl:text>;&#xa;</xsl:text>

      <xsl:if test="@altofila and string-length(@altofila)>0">
         <xsl:value-of select="@nombre"/><xsl:text>.altofila=</xsl:text>
         <xsl:value-of select="@altofila"/>
         <xsl:text>;&#xa;</xsl:text>
      </xsl:if>

      <xsl:if test="@indentado and string-length(@indentado)>0">
         <xsl:value-of select="@nombre"/><xsl:text>.indentado=</xsl:text>
         <xsl:value-of select="@indentado"/>
         <xsl:text>;&#xa;</xsl:text>
      </xsl:if>

      <xsl:if test="@scroll and @scroll='N'">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.sinScroll=true;&#xa;</xsl:text>
      </xsl:if>

      <xsl:choose>
         <xsl:when test="@imgFondo and string-length(@imgFondo)>0">
            <xsl:value-of select="@nombre"/><xsl:text>.imgFondo='</xsl:text>
            <xsl:value-of select="@imgFondo"/>
            <xsl:text>';&#xa;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@nombre"/><xsl:text>.imgFondo=null;&#xa;</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 

      <xsl:if test="@icorama">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.icorama='</xsl:text>
         <xsl:value-of select="@icorama"/>
         <xsl:text>'&#xa;</xsl:text>
      </xsl:if>

      <xsl:if test="@icofinal">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.icofinal='</xsl:text>
         <xsl:value-of select="@icofinal"/>
         <xsl:text>'&#xa;</xsl:text>
      </xsl:if>

      <xsl:if test="@rollOverFila and @rollOverFila='S'">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.SELECC_ANCHO=true;&#xa;</xsl:text>
      </xsl:if>

      <xsl:value-of select="@nombre"/><xsl:text>.imgs=new Array();&#10;</xsl:text>

      <xsl:apply-templates mode="script"/>

      <xsl:text>&#10;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.seleccion0=new Array();&#10;</xsl:text>

      <xsl:if test="@conectorCargaDinamica">
         <xsl:if test="not(@conectorCargaDinamica='')">
            <xsl:value-of select="@nombre"/><xsl:text>.dinamico=true;&#xa;</xsl:text>
            <xsl:value-of select="@nombre"/><xsl:text>.conector='</xsl:text><xsl:value-of select="@conectorCargaDinamica"/><xsl:text>';&#xa;</xsl:text>
         </xsl:if>
      </xsl:if>


      <!-- Llamo a SCROLL -->
      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($arbolscroll,'Div.document.')"/>
         <xsl:value-of select="concat($arbolscroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($nsdoc-local,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@scroll and @scroll='N'">
            <xsl:call-template name="CAPAscript">
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
               <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
               <xsl:with-param name="visibilidad">visible</xsl:with-param>
            </xsl:call-template>
         </xsl:when> 
         <xsl:otherwise>
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
         </xsl:otherwise>
      </xsl:choose> 

   <xsl:if test="@onOpenClose">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.onOpenClose='</xsl:text>
      <xsl:call-template name="escapaCaracterYBarra">
         <xsl:with-param name="text" ><xsl:value-of select="@onOpenClose"/></xsl:with-param>
         <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>';&#xa;</xsl:text>
   </xsl:if>

   </xsl:template>

   <xsl:template match="ARBOL/ICONOS" mode="script">
      <xsl:value-of select="../@nombre"/><xsl:text>.imgs=[</xsl:text>
      <xsl:for-each select="ICONO">
         <xsl:text>'</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@src"/><xsl:text>'</xsl:text>
         <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>];</xsl:text>
   </xsl:template>


   <xsl:template match="RAMA" mode="script">
      <xsl:text>&#10;</xsl:text>
      <xsl:value-of select="../@nombre"/><xsl:text>.entradas=[</xsl:text>

      <xsl:call-template name="TRONCO">
         <xsl:with-param name="nivel" select="@nombre"/>
      </xsl:call-template>

      <xsl:text>];&#xa;</xsl:text>
   
   </xsl:template>


   <xsl:template match="RAMA" mode="scriptarbol">
      <xsl:param name="nivel"/>
      <xsl:text>,</xsl:text>
      <xsl:call-template name="TRONCO">
         <xsl:with-param name="nivel" select="concat($nivel,'.',@nombre)"/>
      </xsl:call-template>
   </xsl:template>

   <xsl:template match="HOJA" mode="scriptarbol">
      <xsl:param name="nivel"/>
      <xsl:text>,</xsl:text>
      <xsl:call-template name="TRONCO">
         <xsl:with-param name="nivel" select="concat($nivel,'.',@nombre)"/>
      </xsl:call-template>
   </xsl:template>


   <xsl:template name="TRONCO">
      <xsl:param name="nivel"/>

      <xsl:variable name="vSituacion">
         <xsl:choose>
           <xsl:when test="name()='RAMA'">P</xsl:when>
           <xsl:otherwise>H</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

<!--	<xsl:if test="not(ancestor::ARBOL/@oncolor)">
      <xsl:if test="$nivel = ancestor::ARBOL/RAMA[1]/@nombre">
         <xsl:text>['raiz','0','a','Nivel 1','P','']</xsl:text>
      </xsl:if>
</xsl:if> 

      <xsl:if test="not(ancestor::ARBOL/@oncolor)">
         <xsl:text>['raiz','0','a','Nivel 1','P','']</xsl:text>
      </xsl:if>
	-->


      <xsl:text>['</xsl:text><xsl:value-of select="$nivel"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@icono"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@codigo"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@texto"/><xsl:text>','</xsl:text>
      <xsl:value-of select="$vSituacion"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@onclick"/><xsl:text>']</xsl:text>
      <xsl:apply-templates mode="scriptarbol">
         <xsl:with-param name="nivel" select="$nivel"/>
      </xsl:apply-templates>
      
   </xsl:template>


   <!--   body  -->
   <xsl:template match="ARBOL" mode="body">
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
      <xsl:choose>
         <xsl:when test="@scroll and @scroll='N'">
            <DIV ID="{@nombre}Scroll"></DIV>
         </xsl:when> 
         <xsl:otherwise>
            <xsl:call-template name="SCROLLbody">
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
               <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="@incy"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose> 

   </xsl:template>


   <xsl:template match="ICONOS|RAMA|HOJA" mode="body">
   </xsl:template>


</xsl:stylesheet>

