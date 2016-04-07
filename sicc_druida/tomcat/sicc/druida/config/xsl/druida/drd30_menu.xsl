<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_menu.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    MENU    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="MENU" mode="head">
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-head"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-head"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <!--   estilo  -->
   <xsl:template match="MENU" mode="estilo">
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-estilo"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-estilo"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <!--   init  -->
   <xsl:template match="MENU" mode="init">
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-init"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-init"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="MENU" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-script">
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
            <xsl:if test="@estiloSelecc">
               <xsl:text>&#xa;window.CLASS_RESALT="</xsl:text>
               <xsl:value-of select="@estiloSelecc"/>
               <xsl:text>";&#xa;</xsl:text>
            </xsl:if>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-script"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <!--   body  -->
   <xsl:template match="MENU" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-body">
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>

         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-body"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="SUBMENU" mode="script">
      <xsl:choose>
         <xsl:when test="ancestor::MENU/@tipo='vertical'">
            <xsl:call-template name="SUBMENU-desp-script"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="SUBMENU-a-script"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="ENTRADA" mode="script">

      <xsl:choose>
         <xsl:when test="ancestor::MENU/@tipo='vertical'">
            <xsl:call-template name="ENTRADA-desp-script"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="ENTRADA-a-script"/>
         </xsl:otherwise>
      </xsl:choose>

   </xsl:template>







   <!--    head    -->
   <xsl:template name="MENU-a-head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3menu.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template>
   <!-- XXXX -->

   <xsl:template name="MENU-desp-head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3menuvert.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   <!--   estilo  -->
   <xsl:template name="MENU-a-estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>
   <xsl:template name="MENU-desp-estilo">
      <!-- Valores por defecto si no hay atributo -->
      <xsl:variable name="vX">
         <xsl:choose>
           <xsl:when test="@x"><xsl:value-of select="@x"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vY">
         <xsl:choose>
           <xsl:when test="@y"><xsl:value-of select="@y"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vAlto">
         <xsl:choose>
           <xsl:when test="@alto and string-length(@alto)>0"><xsl:value-of select="@alto"/></xsl:when>
           <xsl:otherwise>100%</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vAncho">
         <xsl:choose>
           <xsl:when test="@ancho and string-length(@ancho)>0"><xsl:value-of select="@ancho"/></xsl:when>
           <xsl:otherwise>100%</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vColorf">
         <xsl:choose>
           <xsl:when test="@colorf"><xsl:value-of select="@colorf"/></xsl:when>
           <xsl:otherwise>white</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$vX"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vY"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"><xsl:value-of select="@padding"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAncho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAlto"/></xsl:with-param>
         <xsl:with-param name="zindex"/>
         <xsl:with-param name="colorf"><xsl:value-of select="$vColorf"/></xsl:with-param>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
      </xsl:call-template>
   </xsl:template>


   <!--   init  -->
   <xsl:template name="MENU-a-init">
      <xsl:text>posiciona();</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template>
   <xsl:template name="MENU-desp-init">
      <xsl:text>iniciarArbol('Menu</xsl:text><xsl:value-of select="@nombre"/><xsl:text>');</xsl:text>
      <xsl:text>posicionarCapas(Menu</xsl:text><xsl:value-of select="@nombre"/><xsl:text>);</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--   script  -->
   <xsl:template name="MENU-a-script">
      <xsl:text>&#xa;var temporizador0_menu = </xsl:text><xsl:value-of select="@retardo"/><xsl:text>;&#xa;</xsl:text>
      <xsl:apply-templates mode="script"/>
   </xsl:template>

   <xsl:template name="MENU-desp-script">
      <xsl:param name="nsdoc"/>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="contravsb"></xsl:with-param>
      </xsl:call-template>

      <!-- Objeto Menu -->
      <xsl:variable name="vOMenu"><xsl:text>Menu</xsl:text><xsl:value-of select="@nombre"/></xsl:variable> 
<xsl:text>
</xsl:text>
      <xsl:value-of select="$vOMenu"/><xsl:text>=new Object();</xsl:text>

      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nombre='</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>';</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nsdoc='</xsl:text>
      <xsl:value-of select="$nsdoc"/>
      <xsl:text>';</xsl:text>

      <xsl:variable name="vEspNiv1">
         <xsl:choose>
           <xsl:when test="@espacioNivel1"><xsl:value-of select="@espacioNivel1"/></xsl:when>
           <xsl:otherwise><xsl:value-of select="number(@altofila div 2)"/></xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vEspNiv2">
         <xsl:choose>
           <xsl:when test="@espacioNivel2"><xsl:value-of select="@espacioNivel2"/></xsl:when>
           <xsl:otherwise>1</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.espacioNivel1=</xsl:text>
      <xsl:value-of select="$vEspNiv1"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.espacioNivel2=</xsl:text>
      <xsl:value-of select="$vEspNiv2"/>
      <xsl:text>;</xsl:text>

      <xsl:variable name="vMargenNiv1">
         <xsl:choose>
           <xsl:when test="@margennivel1"><xsl:value-of select="@margennivel1"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nivel1posY=</xsl:text>
      <xsl:value-of select="$vMargenNiv1"/>
      <xsl:text>;</xsl:text>

      <xsl:variable name="vMargenNiv2">
         <xsl:choose>
           <xsl:when test="@margennivel2"><xsl:value-of select="@margennivel2"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nivel2posY=</xsl:text>
      <xsl:value-of select="$vMargenNiv2"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.altoFila=</xsl:text>
      <xsl:value-of select="@altofila"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgFondo='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imagenf"/>
      <xsl:text>';</xsl:text>

      <xsl:variable name="vPosH">
         <xsl:choose>
           <xsl:when test="@posh"><xsl:value-of select="@posh"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.PosicionHorizontalDefecto=</xsl:text>
      <xsl:value-of select="$vPosH"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgfondoniv1='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imgfondoniv1"/>
      <xsl:text>';</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgfondoniv2='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imgfondoniv2"/>
      <xsl:text>';</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgfondoniv3='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imgfondoniv3"/>
      <xsl:text>';&#10;</xsl:text>

      <xsl:value-of select="$vOMenu"/><xsl:text>.imgmenos=["</xsl:text><xsl:value-of select="concat($vgImgPath,@imgplegarN)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@imgplegarS)"/><xsl:text>"];&#10;</xsl:text> 
      <xsl:value-of select="$vOMenu"/><xsl:text>.imgmas=["</xsl:text><xsl:value-of select="concat($vgImgPath,@imgdesplegarN)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@imgdesplegarS)"/><xsl:text>"];&#10;</xsl:text> 
      <xsl:value-of select="$vOMenu"/><xsl:text>.iconiv1=["</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv1N)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv1S)"/><xsl:text>"];&#10;</xsl:text> 
      <xsl:value-of select="$vOMenu"/><xsl:text>.iconiv2=["</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv2N)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv2S)"/><xsl:text>"];&#10;</xsl:text> 

      <xsl:variable name="vers">
         <xsl:if test="@version">
            <xsl:value-of select="@version"/>
         </xsl:if>
         <xsl:if test="not(@version)">1</xsl:if>
      </xsl:variable>

      <xsl:value-of select="$vOMenu"/><xsl:text>.niveles=</xsl:text><xsl:if test="$vers='2'">3;&#xa;</xsl:if><xsl:if test="not($vers='2')">2;&#xa;</xsl:if>

      <xsl:value-of select="$vOMenu"/><xsl:text>.opciones=[</xsl:text>
         <xsl:for-each select="SUBMENU">
            <xsl:variable name="vToolTip">
               <xsl:call-template name="langtxt.i10n">
                  <xsl:with-param name="pCod" select="@tooltip"/>
               </xsl:call-template>
            </xsl:variable> 

            <xsl:text>["</xsl:text>

            <xsl:choose>
               <xsl:when test="count(*) > 0">
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>", "</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>", "</xsl:text>
                  <xsl:value-of select="$vToolTip"/>
                  <xsl:text>", [</xsl:text>
                  <xsl:for-each select="*">
                     <xsl:call-template name="MNVERTOPCION"/>
                     <xsl:if test="position()!=last()">,</xsl:if>
                  </xsl:for-each> 
                  <xsl:text>]]</xsl:text>
               </xsl:when>
               <xsl:otherwise><!-- submenu sin opciones es una imagen -->
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>", "</xsl:text>
                  <xsl:value-of select="$vToolTip"/>
                  <xsl:text>",null]</xsl:text>
               </xsl:otherwise>
            </xsl:choose> 
                        
            

            
            <xsl:if test="position()!=last()">,</xsl:if>
         </xsl:for-each>
      <xsl:text>];&#xa;</xsl:text>

      <xsl:apply-templates mode="script"/>
   </xsl:template>


   <!--   body  -->
   <xsl:template name="MENU-a-body">
      <SCRIPT>document.write(display());</SCRIPT>
   </xsl:template>
   <xsl:template name="MENU-desp-body">
   <!-- Si llamo a capa-body me monta las etiquetas del menu, deberia ignorarlas -->
      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

      </DIV>
   </xsl:template>


   <!--   script  -->
   <xsl:template name="SUBMENU-a-script">

      <!-- menu padre -->
      <xsl:variable name="mpadre">
         <xsl:choose>
            <xsl:when test="name(..)='MENU'">null</xsl:when>
            <xsl:otherwise>
               <xsl:text>'</xsl:text><xsl:value-of select="ancestor::SUBMENU[1]/@nombre"/><xsl:text>'</xsl:text>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <!-- entrada padre -->
      <xsl:variable name="epadre">
         <xsl:choose>
            <xsl:when test="name(..)='MENU'">null</xsl:when>
            <xsl:otherwise>
               <xsl:text>'</xsl:text><xsl:value-of select="generate-id(ancestor::ENTRADA[1])"/><xsl:text>'</xsl:text>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>&#xa;menu_add(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@tipo"/><xsl:text>',</xsl:text>
      <xsl:value-of select="$mpadre"/><xsl:text>,</xsl:text>
      <xsl:value-of select="$epadre"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@top"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@left"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@width"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@height"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@offset_x"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@offset_y"/><xsl:text>);</xsl:text>

      <xsl:apply-templates mode="script"/>

   </xsl:template>
   <xsl:template name="SUBMENU-desp-script">
   </xsl:template>


   <!--   script  -->
   <xsl:template name="ENTRADA-a-script">

      <xsl:choose>
         <xsl:when test="@on">
            <xsl:call-template name="ENTRADA_NORMAL"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="ENTRADA_IMG"/>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:apply-templates mode="script"/>

   </xsl:template>
   <xsl:template name="ENTRADA-desp-script">
   </xsl:template>




   <!--   script  -->
   <xsl:template name="ENTRADA_NORMAL">

      <!-- menu padre -->
      <xsl:variable name="mpadre">
         <xsl:value-of select="ancestor::SUBMENU[1]/@nombre"/>
      </xsl:variable>

      <!-- menu hijo -->
      <xsl:variable name="mhijo">
         <xsl:choose>
            <xsl:when test="descendant::SUBMENU/@nombre">
               <xsl:text>'</xsl:text><xsl:value-of select="descendant::SUBMENU/@nombre"/><xsl:text>'</xsl:text>
            </xsl:when>
            <xsl:otherwise><xsl:text>null</xsl:text></xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <!-- nombre entrada -->
      <xsl:variable name="nentrada">
         <xsl:value-of select="generate-id(.)"/>
      </xsl:variable>

      <xsl:variable name="link">
         <xsl:call-template name="escapa">
             <xsl:with-param name="text" select="@enlace"/>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
      </xsl:variable>

      <xsl:text>&#xa;entrada_add(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$mpadre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$nentrada"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="concat($vgImgPath,@off)"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="concat($vgImgPath,@on)"/><xsl:text>',</xsl:text>
      <xsl:value-of select="$mhijo"/><xsl:text>,</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$link"/><xsl:text>',</xsl:text> 
      <xsl:text>'</xsl:text><xsl:value-of select="@info"/><xsl:text>');</xsl:text>

   </xsl:template>


   <!--   script  -->
   <xsl:template name="ENTRADA_IMG">

      <!-- menu padre -->
      <xsl:variable name="mpadre">
         <xsl:value-of select="ancestor::SUBMENU[1]/@nombre"/>
      </xsl:variable>

      <xsl:text>&#xa;imagen_add(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$mpadre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="concat($vgImgPath,@off)"/><xsl:text>');</xsl:text>

   </xsl:template>



   <xsl:template name="MNVERTOPCION">
      <xsl:variable name="vToolTip">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 

      <xsl:variable name="vTexto">
         <xsl:call-template name="SetTxtComponente.i10n"/>
      </xsl:variable> 




      <xsl:choose>
        <xsl:when test="name()='SUBMENU'">
            <xsl:text>["</xsl:text>
            <xsl:value-of select="$vTexto"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="@enlace"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="$vToolTip"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="1"/>
            <xsl:text>"],</xsl:text>

           <xsl:for-each select="ENTRADA|SUBMENU">
               <xsl:variable name="vToolTipES">
                  <xsl:call-template name="langtxt.i10n">
                     <xsl:with-param name="pCod" select="@tooltip"/>
                  </xsl:call-template>
               </xsl:variable> 

               <xsl:if test="name()='ENTRADA'">
                  <xsl:text>["</xsl:text>
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="$vToolTipES"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="2"/>
                  <xsl:text>"]</xsl:text>
                  <xsl:if test="position()!=last()">,</xsl:if>
               </xsl:if>
               <xsl:if test="name()='SUBMENU'">
                  <xsl:text>["</xsl:text>
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="$vToolTipES"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="2"/>
                  <xsl:text>"],</xsl:text>
                  <xsl:for-each select="ENTRADA">
                     <xsl:variable name="vToolTipE">
                        <xsl:call-template name="langtxt.i10n">
                           <xsl:with-param name="pCod" select="@tooltip"/>
                        </xsl:call-template>
                     </xsl:variable> 

                     <xsl:text>["</xsl:text>
                     <xsl:call-template name="SetTxtComponente.i10n"/>
                     <xsl:text>","</xsl:text>
                     <xsl:value-of select="@enlace"/>
                     <xsl:text>","</xsl:text>
                     <xsl:value-of select="$vToolTipE"/>
                     <xsl:text>","</xsl:text>
                     <xsl:value-of select="3"/>
                     <xsl:text>"]</xsl:text>
                     <xsl:if test="position()!=last()">,</xsl:if>
                  </xsl:for-each>
               </xsl:if>
            </xsl:for-each> 
        </xsl:when>
        <xsl:otherwise><!-- es ENTRADA -->
            <xsl:text>["</xsl:text>
            <xsl:value-of select="$vTexto"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="@enlace"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="$vToolTip"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="1"/>
            <xsl:text>"]</xsl:text>
        </xsl:otherwise>
      </xsl:choose> 
      

   </xsl:template>

</xsl:stylesheet>

