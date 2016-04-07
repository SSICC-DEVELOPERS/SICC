<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_combo.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    COMBO    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="COMBO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="COMBO" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>&#xa;#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--   init  -->
   <xsl:template match="COMBO" mode="init">

      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>

      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

      <xsl:variable name="vInicial">
         <xsl:choose>
            <xsl:when test="@multiple='S'">
               <xsl:for-each select="ROWSET/ROW[@check='S']">
                  <xsl:sort select="position()" data-type="text" order="descending" /> 
                  
                  <xsl:text>'</xsl:text>
                  <xsl:value-of select="concat(CAMPO[1],CAMPO[1]/@VALOR)"/>
                  <xsl:text>'</xsl:text>
                  <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if> 
               </xsl:for-each>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vValor">
         <xsl:choose>
           <xsl:when test="$vInicial='' or $vInicial='null'"><xsl:text>null</xsl:text></xsl:when>
           <xsl:otherwise>
               <xsl:value-of select="$vInicial"/>           
           </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      
      <xsl:choose>
        <xsl:when test="@multiple='S'">
            <xsl:text>set('</xsl:text>
            <xsl:value-of select="$vNombreFormulario"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/><xsl:text>',[</xsl:text><xsl:value-of select="$vValor"/><xsl:text>]);
            </xsl:text>
        </xsl:when>
        <xsl:otherwise>
            <xsl:text>set('</xsl:text>
            <xsl:value-of select="$vNombreFormulario"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/><xsl:text>',</xsl:text><xsl:value-of select="$vValor"/><xsl:text>);
            </xsl:text>
        </xsl:otherwise>
      </xsl:choose> 

   </xsl:template>


   <!--   dinamico  -->
   <xsl:template match="COMBO" mode="dinamico">
      <xsl:text>&#xa;</xsl:text>      
      <!-- parte de init -->
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:variable name="vInicial">
         <xsl:choose>
            <xsl:when test="@multiple='S'">
               <xsl:for-each select="ROWSET/ROW[@check='S']">
                  <xsl:sort select="position()" data-type="text" order="descending" /> 
                  
                  <xsl:text>'</xsl:text>
                  <xsl:value-of select="concat(CAMPO[1],CAMPO[1]/@VALOR)"/>
                  <xsl:text>'</xsl:text>
                  <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if> 
               </xsl:for-each>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vValor">
         <xsl:choose>
           <xsl:when test="$vInicial='' or $vInicial='null'"><xsl:text>null</xsl:text></xsl:when>
           <xsl:otherwise>
               <xsl:text></xsl:text><xsl:value-of select="$vInicial"/><xsl:text></xsl:text>       
           </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

         <!-- necesito saber si tengo el atributo valorinicial y test="@valorinicial" parece comportarse de forma diferente segun el parser -->
         <xsl:variable name="valorinicialtest">
             <xsl:for-each select="@*">
               <xsl:if test="name(.)='valorinicial'">
                  <xsl:value-of select="true()"/>
               </xsl:if>
             </xsl:for-each>
         </xsl:variable>
 

      <xsl:variable name="vOpciones">
         <xsl:text>[</xsl:text>
         <xsl:if test="$valorinicialtest='true'">
            <xsl:text>[</xsl:text>

            <xsl:choose>
              <xsl:when test="$vValor='null'">''</xsl:when>
              <xsl:otherwise>'<xsl:value-of select="$vValor"/>'</xsl:otherwise>
            </xsl:choose> 

            <xsl:text>,'</xsl:text>
            <xsl:value-of select="@textoInicial"/>
            <xsl:text>']</xsl:text>
            <xsl:if test="count(ROWSET/ROW)>0"><xsl:text>,</xsl:text></xsl:if> 
         </xsl:if> 

         <xsl:for-each select="ROWSET/ROW">
            <xsl:text>['</xsl:text>
            <xsl:value-of select="concat(CAMPO[1],CAMPO[1]/@VALOR)"/>
            <xsl:text>','</xsl:text>
            <xsl:value-of select="concat(CAMPO[2],CAMPO[2]/@VALOR)"/>
            <xsl:text>']</xsl:text>
            <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if> 
         </xsl:for-each>
         <xsl:text>]</xsl:text>
      </xsl:variable> 
      

         <xsl:choose>
           <xsl:when test="@multiple='S'">
               <xsl:text>DrMainEstatico.set_combo('</xsl:text>
               <xsl:value-of select="$vNombreFormulario"/>
               <xsl:text>.</xsl:text>
               <xsl:value-of select="@nombre"/><xsl:text>',</xsl:text><xsl:value-of select="$vOpciones"/>
               <xsl:text>,[</xsl:text>
               <xsl:choose>
                 <xsl:when test="$vValor='null'">''</xsl:when>
                 <xsl:otherwise><xsl:value-of select="$vValor"/></xsl:otherwise>
               </xsl:choose> 
               <xsl:text>]);</xsl:text>
           </xsl:when>
           <xsl:otherwise>
               <xsl:text>DrMainEstatico.set_combo('</xsl:text>
               <xsl:value-of select="$vNombreFormulario"/>
               <xsl:text>.</xsl:text>
               <xsl:value-of select="@nombre"/><xsl:text>',</xsl:text><xsl:value-of select="$vOpciones"/>
               <xsl:text>,</xsl:text>
               <xsl:choose>
                 <xsl:when test="$vValor='null'">''</xsl:when>
                 <xsl:otherwise><xsl:value-of select="$vValor"/></xsl:otherwise>
               </xsl:choose> 
               <xsl:text>);</xsl:text>
           </xsl:otherwise>
         </xsl:choose> 
         

      <!-- parte de script -->
      <xsl:variable name="vValorInicial">
         <xsl:choose>
           <xsl:when test="$valorinicialtest='true'">
               <xsl:text>'</xsl:text><xsl:value-of select="@valorinicial"/><xsl:text>'</xsl:text>
           </xsl:when>
           <xsl:otherwise><xsl:text>null</xsl:text></xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:text>&#xa;DrMainEstatico.</xsl:text>      
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>valorinicial=</xsl:text><xsl:value-of select="$vValorInicial"/><xsl:text>;</xsl:text>

      <xsl:variable name="vTextoInicial">
         <xsl:variable name="textoinicialtest">
            <xsl:for-each select="@*">
               <xsl:if test="name(.)='textoinicial'">
                  <xsl:value-of select="true()"/>
               </xsl:if>
            </xsl:for-each>
         </xsl:variable>
         <xsl:choose>
            <xsl:when test="$textoinicialtest='true'">
               <xsl:text>'</xsl:text>
               <xsl:value-of select="@textoinicial"/>
               <xsl:text>'</xsl:text>
            </xsl:when>
            <xsl:otherwise><xsl:text>null</xsl:text></xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:text>&#xa;DrMainEstatico.</xsl:text>      
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>textoinicial=</xsl:text><xsl:value-of select="$vTextoInicial"/><xsl:text>;</xsl:text>

   </xsl:template>


   <!--   script  -->
   <xsl:template match="COMBO" mode="script">
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
      <xsl:text>TC='Combo';&#xa;</xsl:text>
      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>SZ=</xsl:text><xsl:value-of select="@size"/><xsl:text>;&#xa;</xsl:text>

      <!-- necesito saber si tengo el atributo valorinicial y test="@valorinicial" parece comportarse de forma diferente segun el parser -->
      <xsl:variable name="valorinicialtest">
          <xsl:for-each select="@*">
            <xsl:if test="name(.)='valorinicial'">
               <xsl:value-of select="true()"/>
            </xsl:if>
          </xsl:for-each>
      </xsl:variable>

      <xsl:variable name="vValorInicial">
         <xsl:choose>
           <xsl:when test="$valorinicialtest='true'">
               <xsl:text>'</xsl:text><xsl:value-of select="@valorinicial"/><xsl:text>'</xsl:text>
           </xsl:when>
           <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>valorinicial=</xsl:text><xsl:value-of select="$vValorInicial"/><xsl:text>;&#xa;</xsl:text>

      <xsl:variable name="vTextoInicial">
         <xsl:variable name="textoinicialtest">
            <xsl:for-each select="@*">
               <xsl:if test="name(.)='textoinicial'">
                  <xsl:value-of select="true()"/>
               </xsl:if>
            </xsl:for-each>
         </xsl:variable>
         <xsl:choose>
            <xsl:when test="$textoinicialtest='true'">
               <xsl:text>'</xsl:text>
               <xsl:value-of select="@textoinicial"/>
               <xsl:text>'</xsl:text>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>


      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>textoinicial=</xsl:text><xsl:value-of select="$vTextoInicial"/><xsl:text>;&#xa;</xsl:text>


      <!-- Funciones eventos COMBO -->

      <!-- onBlur -->
<xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() {
</xsl:text>
   <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',null);
}
</xsl:text>

      <!-- onChange -->
   <xsl:if test="@onchange">
      <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() {
      </xsl:text>
         <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',null);
      </xsl:text>
         <xsl:value-of select="@onchange"/><xsl:text>
      }
      </xsl:text>
   </xsl:if>

      <!-- EVENTO ONKEYDOWN asociado a onreturn-->
      <xsl:if test="@onreturn and string-length(@onreturn)>0">
         <xsl:text>function fonreturn_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) { 
                        var codigoTecla = (window.Event) ? e.which : event.keyCode;
                        if (codigoTecla!=13) {return true;}
                 </xsl:text>
         <xsl:value-of select="@onreturn"/>
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
   <xsl:template match="COMBO" mode="body">
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


   <xsl:template match="COMBO" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:call-template name="langtxt.i10n">
            <xsl:with-param name="pCod" select="@tooltip"/>
         </xsl:call-template>
      </xsl:variable> 

      <SELECT NAME="{@nombre}" SIZE="{@size}">

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
         <xsl:if test="@multiple='S'">
            <xsl:attribute  name="MULTIPLE"/>
         </xsl:if>
         <xsl:attribute name="onBlur">
            <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text> ();</xsl:text>
         </xsl:attribute>

         <!-- solo para IE -->
         <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
         </xsl:if>

         <!-- solo para IE -->
         <xsl:if test="@onreturn or @ontab or @onshtab">
            <xsl:attribute name="onKeyDown">
            <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>();</xsl:text>

            <xsl:if test="@onreturn">
               <xsl:text>fonreturn_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
            </xsl:if>
				<xsl:if test="@ontab">
					<xsl:text>fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
				</xsl:if>
				<xsl:if test="@onshtab">
					<xsl:text>fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(event);</xsl:text>
				</xsl:if>

            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@onfocus">
            <xsl:attribute  name="onFocus">
               <xsl:value-of select="@onfocus" />
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@onchange">
            <xsl:attribute  name="onChange">
               <xsl:text>foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text> ();</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>
         <xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
            <xsl:attribute name="onFocus">
               <xsl:text>this.blur()</xsl:text>
            </xsl:attribute>
            <xsl:attribute name="onBlur">
            </xsl:attribute>
            <xsl:attribute name="onChange">
               <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',document.</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.value.split('|'));</xsl:text>
            </xsl:attribute>
            <xsl:if test="string-length($vgColReadOnly)>0">
               <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
            </xsl:if>
         </xsl:if>

         <xsl:if test="string-length($vgFormElementID)>0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>

         <xsl:if test="@id and string-length(@id)>0">
            <xsl:attribute  name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="string-length($vgColReq) > 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:text>&#xa;</xsl:text>


         <xsl:variable name="vInicial">
            <xsl:choose>
              <xsl:when test="@valorinicial='00'"></xsl:when> <!-- a eliminar, reminiscencia de NW donde tenian todos los combos con valor inicial 00 -->
              <xsl:otherwise><xsl:value-of select="@valorinicial"/></xsl:otherwise>
            </xsl:choose> 
         </xsl:variable> 

         <!-- necesito saber si tengo el atributo valorinicial y test="@valorinicial" parece comportarse de forma diferente segun el parser -->
         <xsl:variable name="valorinicialtest">
             <xsl:for-each select="@*">
               <xsl:if test="name(.)='valorinicial'">
                  <xsl:value-of select="true()"/>
               </xsl:if>
             </xsl:for-each>
         </xsl:variable>
 
         <xsl:if test="$valorinicialtest='true'">
            <OPTION VALUE="{$vInicial}">
               <xsl:attribute name="SELECTED"/>
               <xsl:value-of select="@textoinicial"/>
            </OPTION>
         </xsl:if> 
          

         <xsl:for-each select="ROWSET/ROW">
            <xsl:choose>
               <xsl:when test="CAMPO[1]/@VALOR">
                  <OPTION VALUE="{CAMPO[1]/@VALOR}">
                     <xsl:if test="@check='S'">
                        <xsl:attribute name="SELECTED"/>
                     </xsl:if>
                     <xsl:value-of select="CAMPO[2]/@VALOR" disable-output-escaping="yes"/>
                  </OPTION>
                  <xsl:text>&#xa;</xsl:text>
               </xsl:when>
               <xsl:otherwise>
                  <OPTION VALUE="{CAMPO[1]}">
                     <xsl:if test="@check='S'">
                        <xsl:attribute name="SELECTED"/>
                     </xsl:if>
                     <xsl:value-of select="CAMPO[2]" disable-output-escaping="yes"/>
                  </OPTION>
                  <xsl:text>&#xa;</xsl:text>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:for-each>

      </SELECT>
      <xsl:text>&#xa;</xsl:text>
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template>



   <!--   form  -->
   <xsl:template match="COMBO" mode="form">
      <xsl:text>&#xa;</xsl:text>
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

