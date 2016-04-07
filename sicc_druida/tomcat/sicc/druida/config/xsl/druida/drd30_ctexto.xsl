<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_ctexto.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    CTEXTO    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="CTEXTO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="CTEXTO" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>

   <!--   dinamico  -->
   <xsl:template match="TEXT" mode="dinamico">

      <!-- parte init -->
      <xsl:variable name="vNFormulario" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:text>&#xa;DrMainEstatico.set('</xsl:text>
      <xsl:value-of select="$vNFormulario"/>
      <xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:call-template name="escapa">
         <xsl:with-param name="text" >
            <xsl:if test="@trim = 'N'">
               <xsl:value-of select="translate(@valor, '&#xa;',' ')" />
            </xsl:if>
            <xsl:if test="not(@trim = 'N')">
               <xsl:value-of select="normalize-space(translate(@valor, '&#xa;',' '))" />
            </xsl:if>
         </xsl:with-param>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>');</xsl:text>

      <xsl:variable name="vValidPorDefecto" select="$vgConfig/DATOSPROY/VALIDACIONES/CTEXTO"/>
      <xsl:text>DrMainEstatico.</xsl:text>
      <xsl:value-of select="$vNFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>TV='</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@validacion)=0">
            <xsl:choose>
               <xsl:when test="string-length($vValidPorDefecto)=0">
                  <xsl:text>null</xsl:text>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                      <xsl:with-param name="text" select="normalize-space(translate( $vValidPorDefecto , '&#xa;',' '))"/>
                      <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="normalize-space(translate( @validacion , '&#xa;',' '))"/>
                <xsl:with-param name="caracter">'</xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>';</xsl:text>

   </xsl:template>

   <!--   init  -->
   <xsl:template match="CTEXTO" mode="init">
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>

      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

      <xsl:text>set('</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:call-template name="escapa">
          <xsl:with-param name="text" select="translate(@valor, '&#xa;',' ')"/>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>');</xsl:text>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="CTEXTO" mode="script">
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


      <xsl:variable name="vValidacionDefecto" select="$vgConfig/DATOSPROY/VALIDACIONES/CTEXTO"/>

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
      <xsl:text>";
</xsl:text>

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
      <xsl:text>TC='Texto';
</xsl:text>

      <!-- funciones eventos del INPUT en BODY -->

      <!-- EVENTO ONBLUR -->
        <xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor) { </xsl:text>
            <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',valor);</xsl:text>
            <xsl:value-of select="@onblur"/>
         <xsl:text> }
</xsl:text>

      <!-- EVENTO ONCHANGE -->
         <xsl:if test="@onchange">
        <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor,objeto) { </xsl:text>
               <xsl:text>set('</xsl:text>
               <xsl:value-of select="$frmNombre"/>
               <xsl:text>.</xsl:text>
               <xsl:value-of select="@nombre"/>
               <xsl:text>',valor);</xsl:text>
               <xsl:value-of select="@onchange"/>
         <xsl:text> }
</xsl:text>
         </xsl:if>

      <!-- EVENTO ONFOCUS -->
         <xsl:if test="@onfocus">
        <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() { </xsl:text>
               <xsl:value-of select="@onfocus"/>
         <xsl:text> }
</xsl:text>
         </xsl:if>

      <!-- EVENTO ONKEYPRESS -->
      <xsl:if test="@onkeypress and string-length(@onkeypress)>0">
         <xsl:text>function fokp_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() { </xsl:text>
         <xsl:value-of select="@onkeypress"/>
         <xsl:text> }&#xa;</xsl:text>
      </xsl:if>

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

   </xsl:template>



   <!--   body  -->
   <xsl:template match="CTEXTO" mode="body">
      <INPUT>
         <xsl:attribute name="TYPE">
            <xsl:choose>
               <xsl:when test="@tipo and string-length(@tipo)>0">
                  <xsl:value-of select="@tipo"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>text</xsl:text>
               </xsl:otherwise>
            </xsl:choose>
         </xsl:attribute>

         <xsl:if test="@disabled and @disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>

         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
<!--        ver init    <xsl:value-of select="@valor" disable-output-escaping="yes"/> -->
            <xsl:value-of select="@valor"/>
         </xsl:attribute>
         <xsl:attribute name="SIZE">
            <xsl:value-of select="@size"/>
         </xsl:attribute>
         <xsl:attribute name="MAXLENGTH">
            <xsl:value-of select="@max"/>
         </xsl:attribute>

         <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

         <xsl:if test="string-length($vgColReq) > 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:attribute name="onBlur">
         <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value);</xsl:text>
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

         <xsl:if test="@onfocus">
            <xsl:attribute name="onFocus">
            <xsl:text>fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@onkeypress">
            <xsl:attribute name="onKeyPress">
            <xsl:text>fokp_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>

        <xsl:if test="@ontab or @onshtab">
            <xsl:attribute name="onKeyDown">
            <xsl:text>set('</xsl:text>
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',this.value);</xsl:text>
				<xsl:if test="@ontab">
					<xsl:text>fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
				</xsl:if>
				<xsl:if test="@onshtab">
					<xsl:text>fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
				</xsl:if>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="not(@onkeyup) and $vgConfig/DATOSPROY/EVENTO_ONKEYUP/CTEXTO">
            <xsl:attribute name="onKeyUp">
               <xsl:value-of select="$vgConfig/DATOSPROY/EVENTO_ONKEYUP/CTEXTO"/>
            </xsl:attribute>
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

        <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
        </xsl:if>
         
      </INPUT>
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template>



   <!--   form  -->
   <xsl:template match="CTEXTO" mode="form">
      <xsl:text>
</xsl:text>
      <INPUT TYPE="hidden">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
            <xsl:value-of select="@valor"/>
         </xsl:attribute>
      </INPUT>
   </xsl:template>


</xsl:stylesheet>

