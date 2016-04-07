<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_checkbox.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--   CHECKBOX    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="CHECKBOX" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="CHECKBOX" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>&#xa;#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>

 <!--   dinamico  -->
   <xsl:template match="CHECKBOX" mode="dinamico">
      <xsl:if test="@check and @check='S'">
         <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
         <xsl:text>&#xa;DrMainEstatico.set('</xsl:text>
         <xsl:value-of select="$vNombreFormulario"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','S');</xsl:text>
      </xsl:if>
   </xsl:template>


   <xsl:template match="CHECKBOX" mode="init">

      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>

      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="CHECKBOX" mode="script">
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

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>TV="</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@validacion)=0">
            <xsl:text>null</xsl:text>
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
      <xsl:text>TC='Checkbox';&#xa;</xsl:text>

      <!-- funciones eventos del INPUT en BODY --> 

      <!-- EVENTO ONCLICK -->
      <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>() { </xsl:text>
      <xsl:text>set('</xsl:text>
      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>',null);</xsl:text>
      <xsl:value-of select="@onclick"/>
      <xsl:text> }&#xa;</xsl:text>

      <!-- EVENTO ONFOCUS -->
      <xsl:if test="@onfocus and string-length(@onfocus)>0">
         <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>() { </xsl:text>
         <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>',null);</xsl:text>
         <xsl:value-of select="@onfocus"/>
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

   </xsl:template>



   <!--   body  -->
   <xsl:template match="CHECKBOX" mode="body">
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


   <xsl:template match="CHECKBOX" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 

	  <INPUT TYPE="checkbox">

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

         <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

         <xsl:attribute name="onClick">
            <xsl:text>foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
         </xsl:attribute>

         <xsl:if test="@onfocus and string-length(@onfocus)>0">
            <xsl:attribute name="onFocus">
               <xsl:text>fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@check='S'">
            <xsl:attribute name="CHECKED"/>
         </xsl:if>

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
            <xsl:attribute name="onClick">
		   <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',document.</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.value);</xsl:text>
            </xsl:attribute>
         <xsl:if test="string-length($vgColReadOnly)>0">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
         </xsl:if>
         </xsl:if>

         <xsl:if test="string-length($vgColReq) > 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

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

      </INPUT>

      <xsl:choose>
         <xsl:when test="string-length($vgRadioCheckColorOnText)>0 and $vgRadioCheckColorOnText='S'">
	         <xsl:text  disable-output-escaping="yes">&amp;nbsp;</xsl:text>
			 <SPAN>
				<xsl:if test="string-length($vgFormElementID)>0">
				  <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
				</xsl:if>

				 <xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
					<xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
				 </xsl:if>

				   <xsl:if test="string-length($vgColReq) > 0 and @req='S'">
				<xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
			 </xsl:if>
				<xsl:value-of select="@texto" disable-output-escaping="yes"/>
				</SPAN>
		   <xsl:text  disable-output-escaping="yes">&amp;nbsp;</xsl:text>
         </xsl:when>

         <xsl:when test="@id">
            <SPAN ID="{@id}"><xsl:value-of select="@texto" disable-output-escaping="yes"/></SPAN>
         </xsl:when>

         <xsl:otherwise>
				<xsl:value-of select="@texto" disable-output-escaping="yes"/>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:call-template name="CAMPOREQ"/>
   </xsl:template>



   <!--   form  -->
   <xsl:template match="CHECKBOX" mode="form">
      <xsl:text>
</xsl:text>
      <INPUT TYPE="hidden">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
       <xsl:choose>
         <xsl:when test="@check='S'">S</xsl:when>
         <xsl:otherwise>N</xsl:otherwise>
       </xsl:choose>
         </xsl:attribute>
      </INPUT>
   </xsl:template>


</xsl:stylesheet>

