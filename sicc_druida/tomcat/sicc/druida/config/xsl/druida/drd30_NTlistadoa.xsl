<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_NTlistadoa.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!-- *********** -->
   <!--    LISTADOA -->
   <!-- *********** -->

   <!--    head    -->
   <xsl:template name="LISTADOAhead">

      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>listadoa.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
         <xsl:apply-templates mode="head"/>
      </SCRIPT>
   </xsl:template>


   <!--                                                          -->
   <!--                         ESTILO                           -->
   <!--                                                          -->
   <xsl:template name="LISTADOAestilo">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="vIncX">
         <xsl:choose>
           <xsl:when test="@incx">
               <xsl:value-of select="@incx"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vIncY">
         <xsl:choose>
           <xsl:when test="@incy">
               <xsl:value-of select="@incy"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>
</xsl:text>

      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>capa</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorborde"/></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
         <xsl:with-param name="overflow">hidden</xsl:with-param>
      </xsl:call-template>

      <xsl:variable name="vAncho">
         <xsl:choose>
           <xsl:when test="$vIncY != 0">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>cab</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@pixelsborde"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@pixelsborde"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
<!--         <xsl:with-param name="ancho"><xsl:value-of select="@ancho - 2 * @pixelsborde"/></xsl:with-param> -->
         <xsl:with-param name="ancho"><xsl:value-of select="PRESENTACION/@ancho + $vAncho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
<!--         <xsl:with-param name="overflow">hidden</xsl:with-param>-->
      </xsl:call-template>


         <!-- parametros compuestos igual que en script -->
      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@pixelsborde"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="CABECERA/@height + 2 * @pixelsborde"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
         <xsl:with-param name="ancho">
            <xsl:choose>
               <xsl:when test="$vIncY = 0">
                  <xsl:value-of select="@ancho - 2 * @pixelsborde"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="@ancho - 16 - 2 * @pixelsborde"/>
               </xsl:otherwise>
            </xsl:choose> 

         </xsl:with-param>

         <xsl:with-param name="alto">
            <xsl:choose>
               <xsl:when test="$vIncX = 0">
                  <xsl:value-of select="@alto - CABECERA/@height - 3 * @pixelsborde"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="@alto - CABECERA/@height - 3 * @pixelsborde - 16"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>
   </xsl:template>



   <!--                                                           -->
   <!--                            INIT                           -->
   <!--                                                           -->
   <xsl:template name="LISTADOAinit">
      <xsl:call-template name="SCROLLinit">
         <xsl:with-param name="nombre"><xsl:value-of select="concat(@nombre,'scroll')"/></xsl:with-param>
      </xsl:call-template>
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template>




   <!--                                                           -->
   <!--                           SCRIPT                          -->
   <!--                                                           -->
   <xsl:template name="LISTADOAscript">
      <xsl:param name="nsdoc-local"/>


      <xsl:variable name="vIncX">
         <xsl:choose>
           <xsl:when test="@incx">
               <xsl:value-of select="@incx"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vIncY">
         <xsl:choose>
           <xsl:when test="@incy">
               <xsl:value-of select="@incy"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>


      <xsl:text>
</xsl:text>

      <xsl:variable name="capacapa">
         <xsl:value-of select="concat(@nombre,'capa')"/>
      </xsl:variable>
      <xsl:variable name="capacab">
         <xsl:value-of select="concat(@nombre,'cab')"/>
      </xsl:variable>
      <xsl:variable name="listadoascroll">
         <xsl:value-of select="concat(@nombre,'scroll')"/>
      </xsl:variable>

      <xsl:variable name="capa-nsdoc-parte-local">
         <xsl:value-of select="concat($capacapa,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local">
         <xsl:value-of select="concat($nsdoc-local,'.',$capa-nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capacapa"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
      </xsl:call-template>


   <!-- parte script de la lista propiamente dicha -->
      <xsl:text>
</xsl:text>
      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($listadoascroll,'Div.document.')"/>
         <xsl:value-of select="concat($listadoascroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($capa-nsdoc-local,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_tabIndex=null;</xsl:text>

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_ontab=null;</xsl:text>

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_onshtab=null;</xsl:text>

      <xsl:if test="@tabIndex">
         <xsl:text>&#xa;</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>_tabIndex=</xsl:text>
         <xsl:value-of select="@tabIndex"/>
         <xsl:text>;&#xa;</xsl:text>
      </xsl:if>

      <xsl:if test="@ontab">
         <xsl:text>&#xa;</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>_ontab=true;&#xa;</xsl:text>
      </xsl:if>

      <xsl:if test="@onshtab">
         <xsl:text>&#xa;</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>_onshtab=true;&#xa;</xsl:text>
      </xsl:if>

      <xsl:value-of select="@nombre"/><xsl:text>=new ListadoA(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>',</xsl:text>
      <xsl:value-of select="@multisel"/><xsl:text>,</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imagenoff"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imagenon"/><xsl:text>',</xsl:text>
      <xsl:value-of select="PRESENTACION/@bloquesid"/><xsl:text>,</xsl:text>

      <xsl:text>[</xsl:text> <!-- anchos -->
         <xsl:text>'</xsl:text><xsl:value-of select="PRESENTACION/@ancho"/><xsl:text>',</xsl:text>
         <xsl:for-each select="PRESENTACION/COL">
            <xsl:text>'</xsl:text><xsl:value-of select="@ancho"/><xsl:text>'</xsl:text>
            <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
         </xsl:for-each>
      <xsl:text>],</xsl:text>

      <xsl:text>[</xsl:text> <!-- caracteres -->
         <xsl:text>'</xsl:text><xsl:value-of select="PRESENTACION/@filas"/><xsl:text>',</xsl:text>
         <xsl:for-each select="PRESENTACION/COL">
            <xsl:choose>
               <xsl:when test="position()=1">
                  <xsl:choose>
                     <xsl:when test="ancestor::LISTA/@multisel='0'">
                        <xsl:text>'</xsl:text><xsl:value-of select="@caracteres"/><xsl:text>',</xsl:text>
                     </xsl:when>
                     <xsl:otherwise>
                        <xsl:text></xsl:text> <!-- caracteres para el boton -->
                     </xsl:otherwise>
                   </xsl:choose> 
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>'</xsl:text><xsl:value-of select="@caracteres"/><xsl:text>'</xsl:text>
                  <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:for-each>
      <xsl:text>],</xsl:text>

      <xsl:text>[</xsl:text> <!-- datos -->
      <xsl:for-each select="ROWSET/ROW">
         <xsl:text>[</xsl:text>
            <xsl:for-each select="CAMPO">

      <xsl:variable name="vContenido">
         <xsl:value-of select="concat(.,@VALOR)"/>
      </xsl:variable>
      <xsl:variable name="vContenido2">
         <xsl:value-of select="translate($vContenido, '&#13;',' ')"/>
      </xsl:variable>
               
               <xsl:text>'</xsl:text>
               <!-- para tratar conectores con atributo VALOR y si el en la etiqueta CAMPO
                    concateno ambos, ya que NUNCA vendran los dos -->
               <xsl:call-template name="escapaCaracterYBarra">
                   <xsl:with-param name="text" select="translate($vContenido2, '&#xa;',' ')"/>
                   <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
               <xsl:text>'</xsl:text>
               <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
            </xsl:for-each>
         <xsl:text>]</xsl:text>
         <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>],</xsl:text>

      <xsl:text>'</xsl:text><xsl:value-of select="@sep"/><xsl:text>',</xsl:text>
      <xsl:text>null,</xsl:text>
      <xsl:choose>
         <xsl:when test="@accion=''">null</xsl:when>
         <xsl:otherwise><xsl:text>'</xsl:text><xsl:value-of select="@accion"/><xsl:text>'</xsl:text></xsl:otherwise>
      </xsl:choose>
<xsl:text>);
</xsl:text>
      <xsl:value-of select="@nombre"/>.imgPath='<xsl:value-of select="$vgImgPath"/><xsl:text>';
</xsl:text>

  <xsl:choose>
     <xsl:when test="@dblClick='S'">
	   <xsl:value-of select="@nombre"/><xsl:text>.dblClick=true;
</xsl:text>
     </xsl:when>
     <xsl:otherwise>
	   <xsl:value-of select="@nombre"/><xsl:text>.dblClick=false;
</xsl:text>
     </xsl:otherwise>
   </xsl:choose>      

  <xsl:choose>
     <xsl:when test="@tooltips='S'">
	   <xsl:value-of select="@nombre"/><xsl:text>.tooltips=true;
</xsl:text>
     </xsl:when>
     <xsl:otherwise>
	   <xsl:value-of select="@nombre"/><xsl:text>.tooltips=false;
</xsl:text>
     </xsl:otherwise>
   </xsl:choose>      

	<xsl:if test="@onSetDatos and string-length(@onSetDatos) > 0">
      <xsl:choose>
        <xsl:when test="$pGeneroHTML='S'"><!-- si se está creando la parte cacheable de la página ... -->
           <xsl:value-of select="@nombre"/><xsl:text>.onSetDatos="";&#xa;</xsl:text>
        </xsl:when>
        <xsl:otherwise><!-- si no, como siempre -->
           <xsl:value-of select="@nombre"/><xsl:text>.onSetDatos="</xsl:text><xsl:value-of select="@onSetDatos"/><xsl:text>";&#xa;</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
	</xsl:if>      

	<xsl:if test="@blockImg and string-length(@blockImg) > 0">
	   <xsl:value-of select="@nombre"/><xsl:text>.blockImg.src='</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@blockImg"/><xsl:text>';
</xsl:text>
	</xsl:if>      

	<xsl:if test="@estilosCeldas and string-length(@estilosCeldas) > 0">
	   <xsl:value-of select="@nombre"/><xsl:text>.estilosCeldas="</xsl:text><xsl:value-of select="@estilosCeldas"/><xsl:text>";
</xsl:text>
	</xsl:if> 
   
	  <xsl:if test="@ontab and string-length(@ontab)>0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) { 
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>
		      event.returnValue=false;}
         </xsl:text>
      </xsl:if>

      <xsl:if test="@onshtab and string-length(@onshtab)>0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) { 
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (!shift_pul || codigoTecla!=9) {return true;}&#xa;</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>
		   event.returnValue=false;}
         </xsl:text>
      </xsl:if>

   <!-- FIN parte script de la lista -->

      <xsl:variable name="listascroll">
         <xsl:value-of select="concat(@nombre,'scroll')"/>
      </xsl:variable>


      <xsl:variable name="vAncho">
         <xsl:choose>
           <xsl:when test="$vIncY != 0">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <!-- parametros compuestos igual que en estilo -->
      <xsl:call-template name="SCROLLscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@pixelsborde"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="CABECERA/@height + 2 * @pixelsborde"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho - $vAncho - 2 * @pixelsborde"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto - CABECERA/@height - 3 * @pixelsborde"/></xsl:with-param>
      </xsl:call-template>


      <xsl:value-of select="@nombre"/><xsl:text>scroll.asociax=</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@nombre"/><xsl:text>cab';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>scroll.xoffset=</xsl:text>
      <xsl:value-of select="@pixelsborde"/><xsl:text>;</xsl:text>
      


   </xsl:template>



   <!--                                                          -->
   <!--                           BODY                           -->
   <!--                                                          -->
   <xsl:template name="LISTADOAbody">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="vIncX">
         <xsl:choose>
           <xsl:when test="@incx">
               <xsl:value-of select="@incx"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vIncY">
         <xsl:choose>
           <xsl:when test="@incy">
               <xsl:value-of select="@incy"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>


      <xsl:variable name="capacapa">
         <xsl:value-of select="concat(@nombre,'capa')"/>
      </xsl:variable>
      <xsl:variable name="capacab">
         <xsl:value-of select="concat(@nombre,'cab')"/>
      </xsl:variable>


<!--   ver CAPAbody -->
      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$capacapa"/>
         </xsl:attribute>

         <DIV>
            <xsl:attribute name="ID">
               <xsl:value-of select="$capacab"/>
            </xsl:attribute>

            <xsl:apply-templates select="CABECERA"/>


         </DIV> <!-- de capadivcab-->

         <!-- body de scroll -->
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>scroll</xsl:text>
         </xsl:variable>


         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param> 
            <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
            <xsl:with-param name="omo"><xsl:value-of select="@omo"/></xsl:with-param>
         </xsl:call-template>

      </DIV>  <!-- de $capadiv -->

   </xsl:template>


   <!--                         LO DINAMICO                          -->
   <xsl:template name="LISTADOAdinamico">

      <xsl:if test="@onSetDatos and string-length(@onSetDatos) > 0">
         <xsl:text>&#xa;DrMainEstatico.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>.onSetDatos='</xsl:text>
         <xsl:call-template name="escapa">
             <xsl:with-param name="text" select="translate(@onSetDatos, '&#xa;',' ')"/>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>';&#xa;</xsl:text>
      </xsl:if>

      <xsl:text>&#xa;DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.setDatos(</xsl:text>

      <xsl:text>[</xsl:text> <!-- datos -->
      <!-- falta quitar del caso cacheando los datos -->
      <xsl:for-each select="ROWSET/ROW">
         <xsl:text>[</xsl:text>
            <xsl:for-each select="CAMPO">
               <xsl:variable name="vContenido">
                  <xsl:value-of select="concat(.,@VALOR)"/>
               </xsl:variable>
               <xsl:variable name="vContenido2">
                  <xsl:value-of select="translate($vContenido, '&#13;',' ')"/>
               </xsl:variable>
               <xsl:text>'</xsl:text>
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="translate($vContenido2, '&#xa;',' ')"/>
                   <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
               <xsl:text>'</xsl:text>
               <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
            </xsl:for-each>
         <xsl:text>]</xsl:text>
         <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>]</xsl:text>

      <xsl:text>);&#xa;DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.display();&#xa;</xsl:text>

   </xsl:template>


</xsl:stylesheet>

