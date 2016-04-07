<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_boton.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    BOTON    -->
   <!-- *********** -->

   <!--     head    -->
   <xsl:template match="BOTON" mode="head">
      <!--
      <xsl:if test="generate-id(//BOTON[1])=generate-id()">
         <SCRIPT TYPE="text/javascript">
            <xsl:attribute name="SRC">
               <xsl:value-of select="$jsDruidaPath"/>
               <xsl:text>boton.js</xsl:text>
            </xsl:attribute>
            <xsl:text> </xsl:text>
         </SCRIPT>
      </xsl:if> 
      -->
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="BOTON" mode="estilo">
      <xsl:text>
</xsl:text>

      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;</xsl:text>
      <xsl:text>}</xsl:text>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--     script    -->
   <xsl:template match="BOTON" mode="script">
      <xsl:param name="nsdoc"/>

      <xsl:choose>
         <xsl:when test="@tipo != 'html'">
            <xsl:call-template name="BOTONscript_druida">
              <xsl:with-param name="nsdoc" select="$nsdoc"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONscript_nativo">
              <xsl:with-param name="nsdoc" select="$nsdoc"/>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose> 
      
      <xsl:apply-templates mode="script"/>

   </xsl:template>



      <!-- init -->
   <xsl:template match="BOTON" mode="init">
         <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template>

   <!--     body    -->
   <xsl:template match="BOTON" mode="body">

      <xsl:choose>
         <xsl:when test="@tipo != 'html'">
            <xsl:call-template name="BOTONbody_druida"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONbody_nativo"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>

   <!--     body nativo   -->
   <xsl:template name="BOTONbody_nativo">

      <xsl:choose>
         <xsl:when test="@x!='0' or @y!='0'">
            <DIV ID="{@nombre}Div">
               <form>
                  <xsl:call-template name="BOTONnativo"/>
               </form>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONnativo"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <!--     body druida   -->
   <xsl:template name="BOTONbody_druida">

      <xsl:choose>
         <xsl:when test="@x!='0' or @y!='0'">
            <DIV ID="{@nombre}Div">
                  <xsl:call-template name="BOTON"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTON"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <xsl:template name="BOTON">
      <A HREF="javascript:void(null);">

         <xsl:variable name="vTooltip3">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:variable> 
         <xsl:variable name="vTxt">
            <xsl:call-template name="texto.boton"/>
         </xsl:variable>

         <xsl:if test="string-length($vTooltip3)>0 and $vgConfig/DATOSPROY/TIPOTOOLTIP and $vgConfig/DATOSPROY/TIPOTOOLTIP='NATIVO'">
            <xsl:attribute name="title">
               <xsl:value-of select="$vTooltip3"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:attribute name="onClick">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.click();return false;</xsl:text>
         </xsl:attribute>

         <xsl:attribute name="onMouseOver">
            <xsl:if test="@tipo!='html'">
               <xsl:value-of select="@nombre"/>
               <xsl:text>.onMouseOver();</xsl:text>
            </xsl:if> 
            <xsl:text>window.status='</xsl:text>
            <xsl:value-of select="$vTxt"/>
            <xsl:text>';return true;</xsl:text>
         </xsl:attribute>

         <xsl:if test="@tipo!='html'">
            <xsl:attribute name="onMouseOut">
               <xsl:value-of select="@nombre"/>
               <xsl:text>.onMouseOut()</xsl:text>
            </xsl:attribute>


            <!-- solo para IE -->
            <xsl:if test="@tabIndex">
               <xsl:copy-of select="@tabIndex"/>
            </xsl:if>

            <xsl:if test="@ontab or @onshtab">
               <xsl:attribute name="onKeyDown">
               <xsl:if test="@ontab">
                  <xsl:text>fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
               </xsl:if>
               <xsl:if test="@onshtab">
                  <xsl:text>fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
               </xsl:if>
               </xsl:attribute>
            </xsl:if>

         </xsl:if>

         <xsl:choose>
            <xsl:when test="@tipo='html'">
               <xsl:call-template name="BOTONnativo"/>
            </xsl:when>
            <xsl:when test="@tipo=0">
               <xsl:call-template name="IMAGEN-BOTON">
                  <xsl:with-param name="img0" select="0"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="@estado=true">
                     <xsl:call-template name="IMAGEN-BOTON">
                        <xsl:with-param name="img0" select="3"/>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:call-template name="IMAGEN-BOTON">
                        <xsl:with-param name="img0" select="1"/>
                     </xsl:call-template>
                  </xsl:otherwise>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </A>
   </xsl:template>


   <xsl:template name="IMAGEN-BOTON">
      <xsl:param name="img0"></xsl:param>
      <IMG BORDER="0" ALTo="{@alt}">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
            <xsl:text>I</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="SRC">
            <xsl:value-of select="$vgImgPath"/>
            <xsl:value-of select="@img"/>
            <xsl:value-of select="$img0"/>
            <xsl:text>.gif</xsl:text>
         </xsl:attribute>
      </IMG>
   </xsl:template>

   <xsl:template name="BOTONnativo">

      <xsl:variable name="vTooltip2">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 
      <xsl:variable name="vTxt">
         <xsl:call-template name="texto.boton"/>
      </xsl:variable>

      <input ID="{@ID}" type="button" name="{@nombre}" value="{$vTxt}">
         <xsl:if test="string-length($vTooltip2)>0 and $vgConfig/DATOSPROY/TIPOTOOLTIP and $vgConfig/DATOSPROY/TIPOTOOLTIP='NATIVO'">
            <xsl:attribute name="title">
                  <xsl:value-of select="$vTooltip2"/>
               </xsl:attribute>
            </xsl:if>
         <xsl:attribute name="onMouseOver">
               <xsl:text>window.status='</xsl:text>
               <xsl:value-of select="$vTxt"/>
               <xsl:text>';return true;</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onClick">
            <xsl:value-of select="@accion"/>
            <xsl:text>return false;</xsl:text>
         </xsl:attribute>

         <!-- solo para IE -->
         <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
         </xsl:if>

         <xsl:if test="@ontab or @onshtab">
            <xsl:attribute name="onKeyDown">
               <xsl:if test="@ontab">
                  <xsl:text>fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
               </xsl:if>
               <xsl:if test="@onshtab">
                  <xsl:text>fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
               </xsl:if>
            </xsl:attribute>
         </xsl:if>

      </input>

   </xsl:template>




   <!--     script    -->
   <xsl:template name="BOTONscript_druida">
      <xsl:param name="nsdoc"/>

      <xsl:variable name="vTxt">
         <xsl:call-template name="texto.boton"/>
      </xsl:variable>

      <xsl:variable name="vNombreI">
         <xsl:text>.document.images["</xsl:text> 
         <xsl:value-of select="@nombre"/>
         <xsl:text>I"]</xsl:text> 
      </xsl:variable>
      
      <xsl:variable name="nsdoc-parte-local">
         <xsl:choose>
            <xsl:when test="@x!='0' or @y!='0'">
               <xsl:value-of select="concat('.',@nombre,'Div')"/> 
            </xsl:when>
         </xsl:choose> 
         <xsl:value-of select="$vNombreI"/> 
      </xsl:variable>

      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:variable name="vUnSoloClick">
         <xsl:choose>
            <xsl:when test="@unSoloClick and @unSoloClick='S'">true</xsl:when>
            <xsl:otherwise>false</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vTooltip">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>= new Boton('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="concat($vgImgPath,@img)"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="@tipo"/>
      <xsl:text>',</xsl:text>
      <xsl:choose>
         <xsl:when test="@tipo &lt; 1">
            <xsl:text>false</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="@estado and not(@estado='')">
                  <xsl:value-of select="@estado"/>               
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>false</xsl:text>
               </xsl:otherwise>
            </xsl:choose>
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
            <xsl:text>'</xsl:text>
            <xsl:value-of select="$vTxt"/>
            <xsl:text>'</xsl:text>
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
      <xsl:text>, </xsl:text>
      <xsl:value-of select="$vUnSoloClick"/>
      <xsl:text>, </xsl:text>
      <xsl:choose>
         <xsl:when test="string-length($vTooltip)>0">
            <xsl:text>'</xsl:text><xsl:value-of select="$vTooltip"/><xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>null</xsl:text>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>);
</xsl:text>

   <!-- EVENTO ONTAB -->
   <xsl:if test="@ontab and string-length(@ontab)>0">
      <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
      if (ns) return true;
      var codigoTecla = (window.Event) ? e.which : event.keyCode;
      var shift_pul=(ie)?e.shiftKey:false;
      if (shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
      <xsl:value-of select="@ontab"/>
      <xsl:text>&#xa;            event.returnValue=false;}&#xa;</xsl:text>
   </xsl:if>

   <!-- EVENTO ONSHTAB -->
   <xsl:if test="@onshtab and string-length(@onshtab)>0">
      <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
      if (ns) return true;
      var codigoTecla = (window.Event) ? e.which : event.keyCode;
      var shift_pul=(ie)?e.shiftKey:false;
      if (!shift_pul || codigoTecla!=9) {return true;}&#xa;       </xsl:text>
      <xsl:value-of select="@onshtab"/>
      <xsl:text>&#xa;            event.returnValue=false;}&#xa;</xsl:text>
   </xsl:if>

   </xsl:template>


   <!--     script    -->
   <xsl:template name="BOTONscript_nativo">
      <xsl:param name="nsdoc"/>

     
      <xsl:variable name="nsdoc-parte-local">
         <xsl:choose>
            <xsl:when test="@x!='0' or @y!='0'">
               <xsl:value-of select="concat('.',@nombre,'Div')"/> 
            </xsl:when>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>= new Boton('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>', '</xsl:text>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="@tipo"/>
      <xsl:text>',</xsl:text>
      <xsl:choose>
         <xsl:when test="@tipo &lt; 1">
            <xsl:text>false</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="@estado and not(@estado='')">
                  <xsl:value-of select="@estado"/>               
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>false</xsl:text>
               </xsl:otherwise>
            </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>, </xsl:text>

      <xsl:text>null</xsl:text>

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
      <xsl:text>);
</xsl:text>

   
      <!-- EVENTO ONTAB -->
      <xsl:if test="@ontab and string-length(@ontab)>0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
         var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
                        if (shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>&#xa;                 event.returnValue=false;}&#xa;</xsl:text>
      </xsl:if>

      <!-- EVENTO ONSHTAB -->
      <xsl:if test="@onshtab and string-length(@onshtab)>0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
         var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
                        if (!shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>&#xa;                 event.returnValue=false;}&#xa;</xsl:text>
      </xsl:if>

   </xsl:template>


   <!-- determina el texto del boton en funcion del codigo internacionalizado o atributo alt -->
   <xsl:template name="texto.boton">
      <xsl:choose>
         <xsl:when test="@cod and string-length(@cod) > 0">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@cod"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@alt"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template> 

</xsl:stylesheet>
