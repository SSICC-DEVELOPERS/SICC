<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_comunes.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <xsl:include href="drd30_label.xsl"/>
   <xsl:include href="drd30_labelc.xsl"/>
   <xsl:include href="drd30_labeltbl.xsl"/>
   <xsl:include href="drd30_boton.xsl"/>
   <xsl:include href="drd30_botonera.xsl"/>
   <xsl:include href="drd30_btn.xsl"/>

   <xsl:include href="drd30_arbol.xsl"/>
   <xsl:include href="drd30_menu.xsl"/>
   <xsl:include href="drd30_capa.xsl"/>
   <xsl:include href="drd30_scroll.xsl"/>
   <xsl:include href="drd30_solapas.xsl"/>
   <xsl:include href="drd30_solapa.xsl"/>
   <xsl:include href="drd30_rejilla.xsl"/>

   <xsl:include href="drd30_lista.xsl"/>
   <xsl:include href="drd30_paginado.xsl"/>
   <xsl:include href="drd30_formulario.xsl"/>
   <xsl:include href="drd30_fichero.xsl"/>

   <xsl:include href="drd30_text.xsl"/> <!-- a eliminar -->
   <xsl:include href="drd30_ctexto.xsl"/>

   <xsl:include href="drd30_areatexto.xsl"/>
   <xsl:include href="drd30_checkbox.xsl"/>
   <xsl:include href="drd30_combo.xsl"/>

   <xsl:include href="drd30_tabla.xsl"/>
   <xsl:include href="drd30_radiob.xsl"/>
   <xsl:include href="drd30_imagen.xsl"/>
   <xsl:include href="drd30_calendario.xsl"/>

   <xsl:include href="drd30_arbollista.xsl"/>
   <xsl:include href="drd30_gestorv.xsl"/>

   <xsl:include href="drd30_listado.xsl"/>

   <xsl:include href="drd30_matrizjs.xsl"/>

   <xsl:include href="drd30_trazas.xsl"/>

   <xsl:template name="CAMPOREQ">
      <xsl:text> </xsl:text>
      <xsl:if test="@req='S' and string-length($imgCampoRequerido) > 0">
      <!--   <IMG ALT="{$txtCampoRequerido}"> -->
         <IMG>
            <xsl:attribute name="SRC">
<!--              <xsl:value-of select="$imgDruidaPath"/>  -->
               <xsl:value-of select="$vgImgPath"/>  
               <xsl:value-of select="$imgCampoRequerido"/>
            </xsl:attribute>
         </IMG>
      </xsl:if>
   </xsl:template>

<xsl:template name="break">
   <xsl:param name="text" select="."/>
   <xsl:choose>
   <xsl:when test="contains($text, '&#xa;')">
      <xsl:value-of select="substring-before($text, '&#xa;')"/>
            <xsl:text>\r\n</xsl:text>

      <xsl:call-template name="break">
          <xsl:with-param name="text" select="substring-after($text,
'&#xa;')"/>
      </xsl:call-template>
   </xsl:when>
   <xsl:otherwise>
   <xsl:value-of select="$text"/>
   </xsl:otherwise>
   </xsl:choose>
</xsl:template>

 <!--   dinamico  -->
   <xsl:template match="VAR" mode="dinamico">

      <!-- parte init -->
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:text>&#xa;DrMainEstatico.set('</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:call-template name="escapa">
          <xsl:with-param name="text" select="normalize-space(translate(@valor, '&#xa;',' '))"/>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>');</xsl:text>

      

   </xsl:template>


   <xsl:template match="VAR" mode="init">
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

      <xsl:variable name="texto">
         <xsl:call-template name="break">
             <xsl:with-param name="text" select="@valor"/>
         </xsl:call-template>
      </xsl:variable>

      <xsl:text>set('</xsl:text>
      <xsl:value-of select="$vNombreFormulario"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
<!--      <xsl:value-of select="@valor" disable-output-escaping="yes"/> -->
<!--      <xsl:value-of select="$texto" disable-output-escaping="yes"/> -->
      <xsl:call-template name="escapa">
          <xsl:with-param name="text" select="normalize-space(translate($texto, '&#xa;',' '))"/>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>');</xsl:text>
   </xsl:template>

<!-- <VAR nombre="date11"/> -->
   <xsl:template match="VAR" mode="script">
      <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>TC="Hidden";&#xa;</xsl:text>
   </xsl:template>

   <xsl:template match="VAR" mode="form">
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



   <xsl:template name="FORMULARIOFINAL">

      <xsl:choose>
         <xsl:when test="substring($ProxyServlet,1,2)='nw'">
            <xsl:call-template name="FORMULARIOFINAL-NW"/>
         </xsl:when>
<!--         <xsl:when test="$vgPetri='S'">
            <xsl:call-template name="FORMULARIOFINAL-Petri"/>
         </xsl:when> -->
         <xsl:otherwise>
         
            <TABLE border="0" cellspacing="0" cellpadding="0">
               <TR><TD>
               <FORM METHOD="post">
                  <xsl:attribute name="NAME">
                     <xsl:value-of select="@nombre"/>
                  </xsl:attribute>

                  <xsl:if test="$DR_DEBUG_TIEMPOS='S'">
                     <INPUT TYPE="hidden" NAME="drd_tiempo_inicio" VALUE=""/>
                  </xsl:if>

                  <!-- control back estatico -->
<!--                  <INPUT TYPE="hidden" NAME="d3_back" VALUE=""/> -->
                  
                  <!-- logica/servlet destino -->

                  <!-- Arco de salida en una red de Petri -->
                  <INPUT TYPE="hidden" NAME="DruidaArco" VALUE=""/>
                  <xsl:choose>
                    <xsl:when test="@action">
                        <INPUT TYPE="hidden" NAME="{@action}" VALUE=""/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                          <xsl:when test="@oculto='S'">
                              <INPUT TYPE="hidden" NAME="conectorActionOculto" VALUE="S"/>
                          </xsl:when>
                          <xsl:otherwise>
                              <INPUT TYPE="hidden" NAME="conectorActionOculto" VALUE="N"/>
                          </xsl:otherwise>
                        </xsl:choose> 
                    </xsl:otherwise>
                  </xsl:choose> 

                  <xsl:apply-templates mode="form"/>

                  <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
                  <xsl:call-template name="EXT.form"/>

                  <xsl:if test="not($pGeneroHTML='S')">
                     <xsl:for-each select="//HISTORY/ON">
                        <INPUT TYPE="hidden" NAME="d3history_{@nombre}" VALUE="{@parametros}"/>
                     </xsl:for-each> 
                  </xsl:if>

<!-- INPUT VALUE="ON=proxy&par1=a&par2=234" NAME="d3history_nombre" TYPE="hidden" -->                  

                  <xsl:text>&#xa;</xsl:text>
               </FORM>
               </TD></TR>
            </TABLE>

         </xsl:otherwise>
      </xsl:choose> 
   
   </xsl:template>



   <xsl:template name="FORMULARIOFINAL-NW">
         <TABLE border="0" cellspacing="0" cellpadding="0">
            <TR><TD>
            <FORM METHOD="post">
               <xsl:attribute name="NAME">
                  <xsl:value-of select="@nombre"/>
               </xsl:attribute>
               <!-- logica/servlet destino -->
               
               <xsl:if test="@action">
                  <INPUT TYPE="hidden" NAME="conectorAction" VALUE="{@action}"/>
               </xsl:if>

               <xsl:choose>
                 <xsl:when test="@oculto='S'">
                     <INPUT TYPE="hidden" NAME="conectorActionOculto" VALUE="S"/>
                 </xsl:when>
                 <xsl:otherwise>
                     <INPUT TYPE="hidden" NAME="conectorActionOculto" VALUE="N"/>
                 </xsl:otherwise>
               </xsl:choose> 


               <xsl:apply-templates mode="form"/>
               <xsl:text>&#xa;</xsl:text>
            </FORM>
            </TD></TR>
         </TABLE>
   </xsl:template>


   <xsl:template match="text()" mode ="head"></xsl:template>
   <xsl:template match="text()" mode ="estilo"></xsl:template>
   <xsl:template match="text()" mode ="script"></xsl:template> 
   <xsl:template match="text()" mode ="dinamico"></xsl:template> 
   <xsl:template match="text()" mode ="init"></xsl:template>
   <xsl:template match="text()" mode ="form"></xsl:template>
   <xsl:template match="text()" mode ="script-elem-form"></xsl:template>
<!-- <xsl:template match="text()" mode ="body"><xsl:value-of select="."/></xsl:template> -->

<!--
   <xsl:template match="TABLE|TR|TD|@*" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:copy>
         <xsl:apply-templates mode="script">
            <xsl:with-param name="nsdoc" >
               <xsl:value-of select="$nsdoc"/>
            </xsl:with-param>
         </xsl:apply-templates>
      </xsl:copy>
   </xsl:template>
   -->
   <xsl:template match="*|@*" mode="script" priority="-100">
      <xsl:param name="nsdoc"/>
<!--      <xsl:copy> -->
         <xsl:apply-templates mode="script">
            <xsl:with-param name="nsdoc" >
               <xsl:value-of select="$nsdoc"/>
            </xsl:with-param>
         </xsl:apply-templates>
<!--      </xsl:copy> -->
   </xsl:template>


   <xsl:template match="*" mode="dinamico">
      <xsl:param name="nsdoc"/>
      <xsl:apply-templates mode="dinamico">
         <xsl:with-param name="nsdoc" >
            <xsl:value-of select="$nsdoc"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>


<!--
   <xsl:template match="TABLE|TR|SELECT|OPTION|A|INPUT|@*" mode="body" priority="1000">
       <xsl:copy>
           <xsl:apply-templates select="@*|node()" mode="body"/>
       </xsl:copy>
   </xsl:template>
-->

   <xsl:template match="CABECERA|PRESENTACION|ROWSET|ROW|CAMPO|VAR" mode="body">
   </xsl:template>
   <xsl:template match="*|@*" mode="body" priority="-100">
       <xsl:copy>
           <xsl:apply-templates select="@*|node()" mode="body"/>
       </xsl:copy>
   </xsl:template>


   <!-- Para situar campos ocultos en formularios -->
   <xsl:template match="INPUT|@*" mode="form">
       <xsl:copy>
           <xsl:apply-templates select="@*|node()" mode="form"/>
       </xsl:copy>
   </xsl:template>

<!-- Plantillas de Etiquetas HTML donde se incorpora un directorio global -->
   <xsl:template match="IMG" mode="body">

      <xsl:variable name="vURI">
         <xsl:value-of select="concat($vgImgPath, @src)"/>
      </xsl:variable>

      <IMG SRC="{$vURI}">
         <xsl:copy-of select="@*[name()!= 'src']"/>
      </IMG> 

   </xsl:template>

   <xsl:template match="TD" mode="body">
      <TD>
         <xsl:copy-of select="@*"/>
         <xsl:if test="@background!=''">
            <xsl:attribute name="background">
               <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@background"/>
            </xsl:attribute>
         </xsl:if>
         <xsl:apply-templates mode="body"/>
      </TD>
   </xsl:template>


   <xsl:template match="SELECT" mode="form">
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


   <!-- Identity transformation -->
   <xsl:template match="@*|*">
<!--       <xsl:text>IDENTITY TRANS</xsl:text> -->
       <xsl:copy>
           <xsl:apply-templates select="@*|node()"/>
       </xsl:copy>
   </xsl:template>

<!--
   <xsl:template name="TRAZA">
      <xsl:param name="text"/>
      <xsl:if test="$debug='S'">
         <xsl:comment>[<xsl:value-of select="name()"/> <xsl:value-of select="$text"/>]</xsl:comment> 
      </xsl:if>
   </xsl:template>

   <xsl:template match="comment()" mode="body">
      <xsl:if test="$mostrar_comentarios='S'">
         <xsl:comment><xsl:value-of select="."/></xsl:comment>
      </xsl:if>
   </xsl:template>
-->


   <xsl:template match="PAGINA" mode="init">
      <xsl:apply-templates mode="init"/>
   </xsl:template>

   <xsl:template match="PAGINA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>

   <xsl:template match="PAGINA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:apply-templates mode="body">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>

   <xsl:template name="XMLATTR">
   <xsl:text>
--------------------------------------
   Atributos:
</xsl:text>
   <xsl:for-each select="./@*">
      <xsl:value-of select="name()"/>=<xsl:value-of select="."/><xsl:text>, </xsl:text>
   </xsl:for-each>
   <xsl:text>
--------------------------------------
</xsl:text>
   </xsl:template>


   <xsl:template name="DELIMITA">
      <xsl:param name="cadena"/>
      <xsl:param name="sep"/>
      <xsl:value-of select="concat($sep,$cadena,$sep)"/>
   </xsl:template>

   <xsl:template match="JS|JAVASCRIPT|ESTILO" mode="body">
   </xsl:template>


   <!-- 
      &#x0022 = dobles comillas 
      &#x0027; = apostrofe
   -->
   <xsl:template name="escapa">
      <xsl:param name="text"/>
      <xsl:param name="caracter"/>

      <xsl:choose>
      <xsl:when test="contains($text, $caracter)">
         <xsl:value-of select="substring-before($text, $caracter)"/>
         <xsl:value-of select="concat('\',$caracter)"/>
         <xsl:call-template name="escapa">
             <xsl:with-param name="text" select="substring-after($text,$caracter)"/>
             <xsl:with-param name="caracter" select="$caracter"/>
         </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
         <xsl:value-of select="$text"/>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <!-- 
      &#x0022 = dobles comillas 
      &#x0027; = apostrofe
   -->
   <xsl:template name="escapa2">
      <xsl:param name="text"/>
      <xsl:param name="caracter"/>

      <xsl:choose>
      <xsl:when test="contains($text, $caracter)">
         <xsl:value-of select="substring-before($text, $caracter)"/>
         <xsl:value-of select="concat('\\',$caracter)"/>
         <xsl:call-template name="escapa2">
             <xsl:with-param name="text" select="substring-after($text,$caracter)"/>
             <xsl:with-param name="caracter" select="$caracter"/>
         </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
         <xsl:value-of select="$text"/>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <xsl:template name="escapaCaracterYBarra">
   <!-- si le pasas una comilla por ejemplo hace esto "\abc'" - - > "\\abc\'" (es decir, escapa el caracter y la barra también) -->
      <xsl:param name="text"/>
      <xsl:param name="caracter"/>
      <xsl:variable name="vText" select="$text"/>
      <xsl:variable name="vCaracter" select="$caracter"/>
      <xsl:call-template name="escapa">
         <xsl:with-param name="text">
            <xsl:call-template name="escapa">
               <xsl:with-param name="text" select="$vText"/>
               <xsl:with-param name="caracter">\</xsl:with-param>
            </xsl:call-template>
         </xsl:with-param>
         <xsl:with-param name="caracter" select="$vCaracter"/>
      </xsl:call-template>
   </xsl:template>


   <xsl:template match="OCUPADO" mode="head">
         <SCRIPT TYPE="text/javascript">
            <xsl:attribute name="SRC">
               <xsl:value-of select="$jsDruidaPath"/>
               <xsl:text>d3ocupado.js</xsl:text>
            </xsl:attribute>
            <xsl:text> </xsl:text>
         </SCRIPT>
   </xsl:template>

   <xsl:template match="OCUPADO" mode="script">
      <xsl:variable name="NombreNodoPadre">
         <xsl:value-of select="../@nombre"/>
      </xsl:variable>

   <xsl:variable name="vPos">
      <xsl:choose>
         <xsl:when test="not (@posicion) or @posicion=''">
            <xsl:text>C</xsl:text>
         </xsl:when>
         <xsl:when test="@posicion != 'SI' and @posicion != 'SD' and @posicion != 'II' and @posicion != 'ID'">
            <xsl:text>C</xsl:text>
         </xsl:when>
         <xsl:otherwise><xsl:value-of select="@posicion"/> 
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>


var d3ocupado<xsl:value-of select="../@nombre"/>='<xsl:value-of select="$vPos"/>';
<xsl:value-of select="../@nombre"/>.ocupado=true;
   </xsl:template>

   <xsl:template match="OCUPADO" mode="body">
      <!-- <xsl:apply-templates mode="body"/>  -->
   </xsl:template>


   <xsl:template match="GRAFICO" mode="body">
<!--
http://car3:2005/d3/servlet/DruidaSrvChart?
titulo=Incidencias%20Totales%20por%20Estados%20de%20INDRA&
subtitulo=Del%2001/01/2004%20al%2026/01/2004&
titx=Fecha%20de%20Estado&
tity=Número%20de%20Incidencias&
conector=decoreports01&
control=qy8|01/01/2004|26/01/2004&
width=800&
height=600
-->
      <xsl:variable name="vURLGrafico">
         <xsl:text>DruidaSrvChart?titulo=</xsl:text><xsl:value-of select="TITULO"/><xsl:text>&amp;</xsl:text>
         <xsl:text>subtitulo=</xsl:text><xsl:value-of select="SUBTITULO"/><xsl:text>&amp;</xsl:text>
         <xsl:text>titx=</xsl:text><xsl:value-of select="TEXTO/X"/><xsl:text>&amp;</xsl:text>
         <xsl:text>tity=</xsl:text><xsl:value-of select="TEXTO/Y"/><xsl:text>&amp;</xsl:text>
         <xsl:text>conector=</xsl:text><xsl:value-of select="@conector"/><xsl:text>&amp;</xsl:text>
         <xsl:text>control=</xsl:text><xsl:value-of select="CONTROL"/><xsl:text>&amp;</xsl:text>
         <xsl:text>width=</xsl:text><xsl:value-of select="@ancho"/><xsl:text>&amp;</xsl:text>
         <xsl:text>height=</xsl:text><xsl:value-of select="@alto"/><xsl:text>&amp;</xsl:text>

	 <xsl:choose>
		<xsl:when test="@leyenda">
			<xsl:text>tipo=</xsl:text><xsl:value-of select="@leyenda"/><xsl:text>&amp;</xsl:text>
		</xsl:when>
		<xsl:otherwise>
			<xsl:text>leyenda=true&amp;</xsl:text>
		</xsl:otherwise>
	</xsl:choose>
	 
	<xsl:choose>
		<xsl:when test="@tipo">
			<xsl:text>tipo=</xsl:text><xsl:value-of select="@tipo"/>
		</xsl:when>
		<xsl:otherwise>
			<xsl:text>tipo=3</xsl:text>
		</xsl:otherwise>
	</xsl:choose>
      </xsl:variable> 
      
      <IMG SRC="{$vURLGrafico}" ALT="{TITULO}" width="{@ancho}" height="{@alto}"/>
   </xsl:template>

   <xsl:template name="OCUPADOFINAL">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:variable name="NombreNodoPadre">
         <xsl:value-of select="../@nombre"/>
      </xsl:variable>


      <xsl:variable name="vFondo">
         <xsl:choose>
            <xsl:when test="@colorf or string-length(@colorf)>0">
               <xsl:text>background-color:</xsl:text>
               <xsl:value-of select="@colorf"/>
               <xsl:text>;layer-background-color:</xsl:text>
               <xsl:value-of select="@colorf"/>
               <xsl:text>;</xsl:text>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <DIV ID="d3ocupado{$NombreNodoPadre}" 
           style="position:absolute;visibility:hidden;{$vFondo}">
      <xsl:apply-templates mode="body">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
      </DIV>      
   </xsl:template>

   <xsl:template match="INCLUIR-HTML" mode="body">
      <xsl:variable name="fichero" select="concat('../xml/gui/',@href)"/>
<!--      <xsl:copy-of select="document($fichero)/x"/>  -->
      <xsl:apply-templates select="document($fichero)/HTML/*" />
   </xsl:template>

   <xsl:template match="HISTORY" mode="body">
      <!-- <xsl:apply-templates mode="body"/>  -->
   </xsl:template>



   <!-- Internacionalizacion de componentes 
        Un componente puede llevar el texto implicito [en un atributo @valor o @info], 
        o un codigo [@cod] internacionalizado que se obtiene de la configuracion de idiomas (idiomas.xml)
   -->
   <xsl:template name="SetTxtComponente.i10n">
      <xsl:choose>
         <xsl:when test="@cod">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@cod"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>

            <xsl:variable name="vTexto">
               <xsl:choose>
                  <xsl:when test="@valor">
                     <xsl:value-of select="@valor"/>                         
                  </xsl:when>
                  <xsl:when test="@info">
                     <xsl:value-of select="@info"/>                         
                  </xsl:when>
                  <xsl:otherwise>-error-</xsl:otherwise>
               </xsl:choose> 
            </xsl:variable> 

            <xsl:choose>
               <xsl:when test="string-length(@RC)>0 and @RC='S'">
                  <xsl:call-template name="break">
                     <xsl:with-param name="text" select="$vTexto"/>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate($vTexto, '&#xa;', ' ')"/>
                        <xsl:with-param name="caracter">'</xsl:with-param>
                     </xsl:call-template>
                  </xsl:otherwise>
             </xsl:choose> 

         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>



   <xsl:template name="SetTxtComponente">
      <xsl:choose>
         <xsl:when test="@cod">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@cod"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>

            <xsl:choose>
               <xsl:when test="string-length(@RC)>0 and @RC='S'">
                  <xsl:call-template name="break">
                     <xsl:with-param name="text" select="@valor"/>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate(@valor, '&#xa;',' ')"/>
                        <xsl:with-param name="caracter">'</xsl:with-param>
                     </xsl:call-template>
                  </xsl:otherwise>
             </xsl:choose> 

         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>

   <xsl:template name="langtxt"> <!-- deprecated, usar mejor langtxt.i10n -->
      <xsl:param name="pCod"/>
      <xsl:choose>
         <xsl:when test="/PAGINA/@xml:lang">
            <xsl:variable name="vgLang" select="/PAGINA/@xml:lang"/>
            <xsl:value-of select="$vgTextos/MENSAJES/IDIOMA[lang($vgLang)]/MENSAJE[@CODIGO=$pCod]" /> 
        </xsl:when>
        <xsl:otherwise>
            <xsl:value-of select="$pCod" /><xsl:text>-Idioma no definido</xsl:text>
        </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>

   <xsl:template name="langtxt.i10n">
      <xsl:param name="pCod"/>
      <xsl:choose>
         <xsl:when test="/PAGINA/@xml:lang">
            <xsl:variable name="vgLang" select="/PAGINA/@xml:lang"/>
            <xsl:variable name="vTxt.i10n" select="$vgTextos/MENSAJES/IDIOMA[lang($vgLang)]/MENSAJE[@CODIGO=$pCod]"/>
            <xsl:value-of select="$vTxt.i10n" /> 
        </xsl:when>
        <xsl:otherwise>
            <xsl:value-of select="$pCod" />
        </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>


   <xsl:template name="label.tooltip.script">

<!--         <xsl:when test="$vgConfig/DATOSPROY/IMAGENES/ESPACIADO/ICONO">-->
      <xsl:if test="@tooltip">
         <xsl:variable name="vTxt">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:variable>

         <xsl:value-of select="@nombre"/>
         <xsl:text>.tooltip='</xsl:text>
         <xsl:choose>
            <xsl:when test="string-length($vTxt)=0 and $vgConfig/DATOSPROY/FORZARTOOLTIP and $vgConfig/DATOSPROY/FORZARTOOLTIP='S'">
               <xsl:value-of select="@tooltip"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="$vTxt"/>
           </xsl:otherwise>
         </xsl:choose> 
         <xsl:text>'; </xsl:text>
      </xsl:if> 
   </xsl:template>

   <xsl:template name="DrdImgPath">
      <xsl:choose>
         <xsl:when test="/PAGINA/@xml:lang">
            <xsl:variable name="vLang" select="/PAGINA/@xml:lang"/>
            <xsl:value-of select="$vgConfig/DATOSPROY/IMGPATH[lang($vLang)]"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$imgPath"/>
        </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>

    <!-- el codigo del Editor visual no se trata -->
   <xsl:template match="DRUIDABUILDER" mode="body">
   </xsl:template>

</xsl:stylesheet>

