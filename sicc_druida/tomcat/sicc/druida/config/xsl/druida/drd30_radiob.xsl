<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_radiob.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                version="1.0">

   <!--    RADIOB    -->
   <!-- ********** -->

   <xsl:include href="drd30_rbinput.xsl"/>

   <!--    head    -->
   <xsl:template match="RADIOB" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="RADIOB" mode="estilo">
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
   <xsl:template match="RADIOB" mode="script">
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
      <xsl:text>TC='Radio';&#xa;</xsl:text>


      <!-- funciones eventos del INPUT en BODY --> 

      <!-- EVENTO ONFOCUS (depende del RBINPUT) -->

      <!-- EVENTO ONCLICK -->
      <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor) { </xsl:text>
      <xsl:text>set('</xsl:text>
      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>',valor);</xsl:text>
      <xsl:value-of select="@onclick"/>
      <xsl:text> }
</xsl:text>


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

      <xsl:if test="@onshtab and string-length(@onshtab)>0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (!shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>&#xa;		 event.returnValue=false;}&#xa;</xsl:text>
      </xsl:if>


     <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="RADIOB" mode="script-elem-form">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:apply-templates mode="script-elem-form">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>



   <!--   body  -->
   <xsl:template match="RADIOB" mode="body">
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

   <!--   body  -->
   <xsl:template match="RADIOB" mode="bodyNormal">
      <xsl:apply-templates select="RBINPUT" mode="body"/>
      <!-- Problemas si la orientación de los radiobuttons es vertical... -->
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template>



   <!--   form  -->
   <xsl:template match="RADIOB" mode="form">
      <xsl:text>
</xsl:text>
      <INPUT TYPE="hidden">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
            <xsl:value-of select="RBINPUT[@check='S']/@valor"/>
         </xsl:attribute>
      </INPUT>

   </xsl:template>

</xsl:stylesheet>

