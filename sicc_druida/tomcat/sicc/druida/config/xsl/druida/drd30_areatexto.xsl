<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_areatexto.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    AREATEXTO    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="AREATEXTO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="AREATEXTO" mode="estilo">
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
   <xsl:template match="AREATEXTO" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>&#xa;</xsl:text>

      <xsl:variable name="iedoc">
         <xsl:for-each select="ancestor::TABLA">
            <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
         </xsl:for-each>
         <xsl:value-of select="@nombre"/>
      </xsl:variable>

      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>NS='</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>';&#xa;</xsl:text>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>IE='</xsl:text>
      <xsl:value-of select="$iedoc"/>
      <xsl:text>';&#xa;</xsl:text>

      <xsl:if test="@trim = 'N'">
         <xsl:value-of select="$frmNombre"/>.<xsl:value-of select="@nombre"/><xsl:text>NOTRIM=true;&#xa;</xsl:text>
      </xsl:if>

      <xsl:variable name="vValidacionDefecto" select="$vgConfig/DATOSPROY/VALIDACIONES/TEXTAREA"/>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>TV="</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@validacion)=0">
            <xsl:choose>
               <xsl:when test="string-length($vValidacionDefecto)=0">
                  <xsl:text>null</xsl:text>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$vValidacionDefecto"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@validacion"/>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>";&#xa;</xsl:text>

      <xsl:choose>
         <xsl:when test="string-length(@msjreq) > 0">
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>MR='</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>';&#xa;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>MR='</xsl:text>
            <xsl:value-of select="$vgTxtCampoRequerido"/>
            <xsl:text>';&#xa;</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 




      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>MV=</xsl:text>
      <xsl:choose>
        <xsl:when test="@req='S'">'C';</xsl:when>
        <xsl:otherwise>'c';</xsl:otherwise>
      </xsl:choose>
      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>TC='Textarea';&#xa;</xsl:text>

      <!-- funciones eventos del INPUT en BODY --> 
      <!-- EVENTO ONBLUR -->
         <xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(valor) { </xsl:text>
         <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>',valor);</xsl:text>
         <xsl:value-of select="@onblur"/>
         <xsl:text> }&#xa;</xsl:text>

      <!-- EVENTO ONCHANGE -->
         <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(valor,objeto) { </xsl:text>
         <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>',valor);</xsl:text>
         <xsl:value-of select="@onchange"/>
         <xsl:text> }&#xa;</xsl:text>

      <!-- EVENTO ONFOCUS -->
      <xsl:if test="@onfocus and string-length(@onfocus)>0">
         <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>() { </xsl:text>
         <xsl:value-of select="@onfocus"/>
         <xsl:text> }&#xa;</xsl:text>
      </xsl:if>

      <!-- EVENTO ONKEYDOWN -->
      <xsl:if test="@onkeydown and string-length(@onkeydown)>0">
         <xsl:text>function fokd_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>() { </xsl:text>
         <xsl:value-of select="@onkeydown"/>
         <xsl:text> }&#xa;</xsl:text>
      </xsl:if>


      <!-- EVENTO ONTAB -->
	   <xsl:if test="@ontab and string-length(@ontab)>0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>&#xa;		 event.returnValue=false;}&#xa;</xsl:text>
      </xsl:if>

      <!-- EVENTO ONSHTAB -->
	   <xsl:if test="@onshtab and string-length(@onshtab)>0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (!shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>&#xa;		 event.returnValue=false;}&#xa;</xsl:text>
      </xsl:if>

      <!-- EVENTO ONKEYUP -->
      <xsl:if test="(@onkeyup and string-length(@onkeyup)>0) or (@max and string-length(@max)>0)">
         <xsl:text>function foku_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(valor) { </xsl:text>
         <xsl:value-of select="@onkeyup"/>

         <xsl:text>LimitaAreatexto('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>', valor, </xsl:text>
         <xsl:value-of select="@max"/>
         <xsl:text>);&#xa;</xsl:text>

         <xsl:text> }&#xa;</xsl:text>
      </xsl:if>

   </xsl:template>



   <!--   body  -->
   <xsl:template match="AREATEXTO" mode="body">
      <xsl:choose>
         <xsl:when test="@x and @y">
            <DIV ID="{@nombre}CapRecipnt">
               <xsl:apply-templates select="." mode="bodyNormal"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:apply-templates select="." mode="bodyNormal"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <xsl:template match="AREATEXTO" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 

      <TEXTAREA>

         <xsl:if test="@disabled and @disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>

         <xsl:if test="string-length($vToolTip)>0"> 
               <xsl:attribute name="onMouseOver"> 
                  <xsl:text>tooltip(event, '</xsl:text><xsl:value-of select="$vToolTip"/><xsl:text>')</xsl:text> 
               </xsl:attribute>  
               <xsl:attribute name="onMouseOut"> 
                  <xsl:text>tooltip()</xsl:text> 
               </xsl:attribute>  
         </xsl:if>  

         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="ROWS">
            <xsl:value-of select="@rows"/>
         </xsl:attribute>
         <xsl:attribute name="COLS">
            <xsl:value-of select="@cols"/>
         </xsl:attribute>

         <xsl:attribute name="onBlur">
               <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(this.value);</xsl:text>
         </xsl:attribute>

         <xsl:choose>
            <xsl:when test="@onchange and string-length(@onchange)>0">
               <xsl:attribute name="onChange">
                  <xsl:text>foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value,this);</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="$vgConfig/DATOSPROY/EVENTO_ONCHANGE/CTEXTO">
                     <xsl:attribute name="onChange">
                        <xsl:value-of select="$vgConfig/DATOSPROY/EVENTO_ONCHANGE/CTEXTO"/>
                     </xsl:attribute>
                  </xsl:when>
                  <xsl:otherwise/>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:if test="@onfocus and string-length(@onfocus)>0">
            <xsl:attribute name="onFocus">
               <xsl:text>fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>



<!--
         <xsl:if test="@onkeydown and string-length(@onkeydown)>0">
            <xsl:attribute name="onkeydown">
               <xsl:text>fokd_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>
-->

         <!-- solo para IE -->
         <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
         </xsl:if>

         <xsl:if test="@onkeydown or @ontab or @onshtab">
            <xsl:attribute name="onKeyDown">
            
            <!--
            <xsl:text>set('</xsl:text>
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',this.value);</xsl:text>
            -->

               <xsl:if test="@onkeydown and string-length(@onkeydown)>0">
                  <xsl:text>fokd_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
               </xsl:if>
               <xsl:if test="@ontab">
                  <xsl:text>fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
               </xsl:if>
               <xsl:if test="@onshtab">
                  <xsl:text>fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
               </xsl:if>
            </xsl:attribute>
         </xsl:if>


<!--
         <xsl:if test="@onkeyup and string-length(@onkeyup)>0">
            <xsl:attribute name="onkeyup">
               <xsl:text>foku_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>
-->
         <xsl:choose>
            <xsl:when test="(@onkeyup and string-length(@onkeyup)>0) or (@max and string-length(@max)>0)">
               <xsl:attribute name="onkeyup">
                  <xsl:text>foku_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(this.value);</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:when test="$vgConfig/DATOSPROY/EVENTO_ONKEYUP/TEXTAREA">
               <xsl:attribute name="onkeyup">
                  <xsl:value-of select="$vgConfig/DATOSPROY/EVENTO_ONKEYUP/TEXTAREA"/>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise></xsl:otherwise>
         </xsl:choose>


         <xsl:if test="string-length($vgFormElementID)>0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>

         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
               <xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@id">
            <xsl:attribute  name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

<xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
			<xsl:attribute  name="READONLY">
               <xsl:text></xsl:text>
            </xsl:attribute>
            <xsl:attribute name="onFocus">
            <xsl:text>this.blur();</xsl:text>
            </xsl:attribute>

         <xsl:if test="string-length($vgColReadOnly)>0">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
         </xsl:if>

 </xsl:if>

         <xsl:if test="string-length($vgColReq) > 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:variable name="vTexto" select="concat(., @valor)"/>
         
         <xsl:choose>
            <xsl:when test="$vTexto and string-length($vTexto)>0">
               <xsl:value-of select="$vTexto" disable-output-escaping="yes"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text></xsl:text>
            </xsl:otherwise>
         </xsl:choose> 


      </TEXTAREA>
      <xsl:call-template name="CAMPOREQ"/>
   </xsl:template>



   <!--   form  -->
   <xsl:template match="AREATEXTO" mode="form">

         <xsl:variable name="vTexto" select="concat(., @valor)"/>

      <xsl:text>
</xsl:text>
      <INPUT TYPE="hidden">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
            <xsl:value-of select="$vTexto"/>
         </xsl:attribute>


      </INPUT>
   </xsl:template>


</xsl:stylesheet>

