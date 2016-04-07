<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_rbinput.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    RBINPUT    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="RBINPUT" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="RBINPUT" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="RBINPUT" mode="script">
      <xsl:param name="nsdoc"/>

      <!-- funciones eventos del INPUT en BODY estan definidas en RADIOB -->  

      <!-- EVENTO ONFOCUS -->
      <xsl:if test="@onfocus and string-length(@onfocus)>0">
         <xsl:text>function fof_</xsl:text><xsl:value-of select="../@nombre"/><xsl:number/><xsl:text>() { </xsl:text>
          <xsl:value-of select="@onfocus"/>
         <xsl:text> }
</xsl:text>
      </xsl:if>

        <xsl:apply-templates mode="script"/>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="RBINPUTkk" mode="script-elem-form">
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
   <xsl:template match="RBINPUT" mode="body">
      <xsl:variable name="vToolTip">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 

      <INPUT TYPE="radio">

         <xsl:if test="../@disabled and ../@disabled='S'">
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
            <xsl:value-of select="../@nombre"/>
         </xsl:attribute>
          <xsl:attribute name="VALUE">
            <xsl:value-of select="@valor"/>
         </xsl:attribute>
         <xsl:if test="string-length($vgFormElementID)>0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>
         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
            </xsl:attribute>
         </xsl:if>
         <xsl:if test="@id">
            <xsl:attribute  name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>
         <xsl:if test="string-length($vgColReq) > 0 and ../@req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>
         <xsl:if test="@check='S'">
            <xsl:attribute name="CHECKED"/>
         </xsl:if>
<!--         <xsl:attribute name="onClick">
            <xsl:text>foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(this.value);</xsl:text>
            <xsl:text>return true;</xsl:text>
         </xsl:attribute> -->
         <xsl:attribute name="onClick">
			 <xsl:choose>
				<xsl:when test="@onclick and string-length(@onclick)>0">
					<xsl:text>if (</xsl:text><xsl:value-of select="@onclick"/><xsl:text>) {foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(this.value);return true;} else {foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>('');return false;}</xsl:text>
				</xsl:when>
			   <xsl:otherwise>
					<xsl:text>foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(this.value);</xsl:text>
					<xsl:text>return true;</xsl:text>
			   </xsl:otherwise>
			 </xsl:choose>      
   		</xsl:attribute>
         <xsl:if test="@onfocus and string-length(@onfocus)>0">
            <xsl:attribute name="onFocus">
               <xsl:text>fof_</xsl:text><xsl:value-of select="../@nombre"/><xsl:number/><xsl:text>();</xsl:text>
               <xsl:text>return true;</xsl:text>
            </xsl:attribute>
         </xsl:if>

	      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>
         <xsl:if test="(../@readonly and ../@readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
               <xsl:attribute name="onClick">
	   	         <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>',document.</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.value);</xsl:text>
               </xsl:attribute>
      <!-- Elimina evento onfocus -->
			   <xsl:attribute name="onFocus">
            </xsl:attribute>

            <xsl:if test="string-length($vgColReadOnly)>0">
               <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
            </xsl:if>

         </xsl:if>


         <!-- solo para IE -->
         <xsl:if test="../@tabIndex">
            <xsl:copy-of select="../@tabIndex"/>
         </xsl:if>
         

          <xsl:if test="../@ontab or ../@onshtab">
            <xsl:attribute name="onKeyDown">
				<xsl:if test="../@ontab">
					<xsl:text>fontab_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(event);</xsl:text>
				</xsl:if>
				<xsl:if test="../@onshtab">
					<xsl:text>fonshtab_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(event);</xsl:text>
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

			 <xsl:if test="(../@readonly and ../@readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
				<xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
			 </xsl:if>

	           <xsl:if test="string-length($vgColReq) > 0 and ../@req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

      <xsl:apply-templates mode="body"/>

	  </SPAN>
	   <xsl:text  disable-output-escaping="yes">&amp;nbsp;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
		      <xsl:apply-templates mode="body"/>
         </xsl:otherwise>

      </xsl:choose>

      <xsl:if test="../@tipo='V'"><br/></xsl:if>
   </xsl:template>

   <xsl:template match="RBINPUT/text()" mode="body">

      <xsl:variable name="elTextoDelRb">
         <xsl:choose>
            <xsl:when test="../@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="../@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="."/>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="../@id">
            <SPAN ID="{../@id}">
               <xsl:value-of select="$elTextoDelRb"/>
            </SPAN>
         </xsl:when>
         <xsl:when test="../../@id">
            <SPAN ID="{../../@id}">
               <xsl:value-of select="$elTextoDelRb"/>
            </SPAN>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$elTextoDelRb"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

</xsl:stylesheet>

