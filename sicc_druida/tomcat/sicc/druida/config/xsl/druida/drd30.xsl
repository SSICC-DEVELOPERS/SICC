<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->

<!DOCTYPE xsl:stylesheet [
   <!ENTITY cia      "INDRA Sistemas, S.A.">
   <!ENTITY druidav  "Druida 3.0">
   <!ENTITY lt  "&#x003C;"> <!-- re-declarados para su uso en las plantillas -->
   <!ENTITY amp  "&#x0026;">
   <!ENTITY nbsp "&#160;">
]>

<!--
Use &#xA0; (or &#160;) The code value in Unicode for NO-BREAK SPACE is U+0020. or Define &nbsp; by including it in a DOCTYPE thing at the start of the stylesheet:
<!DOCTYPE xsl:stylesheet [<!ENTITY nbsp "&#160;">]>
-->



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:drdencb64="es.indra.druida.util.DruidaEncodingBase64"
                exclude-result-prefixes="drdencb64">

   <!-- debe ir en primer lugar... -->
   <xsl:import href="drd30_extensible.xsl"/>

   <xsl:include href="drd30_params.xsl"/>
   <xsl:include href="drd30_config.xsl"/>
   <xsl:include href="drd30_comunes.xsl"/>


   <!-- Plantilla para el elemento raiz -->
   <xsl:template match="/">
      <xsl:apply-templates/>
   </xsl:template>


   <!-- Plantilla para el elemento raiz (PAGINA) -->
   <xsl:template match="PAGINA">
      <xsl:choose>
         <xsl:when test="$pDinamico='S'">
            <xsl:call-template name="PAGINA-dinamico"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="PAGINA-estatico"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template>


 <xsl:template name="PAGINA-dinamico">
      <HTML>
         <HEAD>

            <META NAME="Author" CONTENT="&cia;"/>
            <META NAME="Generator" CONTENT="&druidav;"/>


            <TITLE>
               <xsl:value-of select="@titulo"/>
            </TITLE>
            <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1"/>
            <SCRIPT>
               <xsl:text>&#xa;function drdSets(elDocument) {</xsl:text>
               <xsl:apply-templates mode="dinamico">
                  <xsl:with-param name="nsdoc">document</xsl:with-param>
               </xsl:apply-templates>
               <xsl:text>&#xa;</xsl:text>

               <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
               <xsl:call-template name="EXT.dinamico"/>

               <xsl:value-of select="$pJS"/>

               <xsl:text>&#xa;var formulariosUsuario='|</xsl:text>
               <xsl:for-each select="//FORMULARIO">
                  <xsl:value-of select="@nombre"/>
                  <xsl:text>|</xsl:text>
               </xsl:for-each>
               <xsl:text>';&#xa;</xsl:text>

               <xsl:text>&#xa;var elstrform='</xsl:text>

               <xsl:for-each select="//HISTORY/ON">
                  <xsl:text disable-output-escaping="yes">&lt;INPUT TYPE="hidden" NAME="d3history_</xsl:text>
                  <xsl:value-of select="@nombre"/>
                  <xsl:text disable-output-escaping="yes">" VALUE="</xsl:text>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" >
                        <xsl:value-of select="translate(@parametros, '&#xa;',' ')" />
                     </xsl:with-param>
                      <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
                  <xsl:text disable-output-escaping="yes">"></xsl:text>
               </xsl:for-each>
               <xsl:text>';&#xa;</xsl:text>

               <xsl:text disable-output-escaping="yes">var f=0;&#xa;for (f=0;f&lt;elDocument.forms.length;f++)   {&#xa;</xsl:text>
               <xsl:text disable-output-escaping="yes">if(formulariosUsuario.indexOf('|'+elDocument.forms[f].name+'|')!=-1) {&#xa;</xsl:text>               
               <xsl:text disable-output-escaping="yes">elDocument.forms[f].innerHTML=elDocument.forms[f].innerHTML+elstrform;&#xa;}&#xa;</xsl:text>
               <xsl:text disable-output-escaping="yes">}&#xa;</xsl:text>
               <xsl:text>&#xa; if (DrMainEstatico.oculta_asignar) {DrMainEstatico.d3ocupado_ocultar('d3general');} &#xa;</xsl:text>
               <xsl:text>}&#xa;</xsl:text>
               <xsl:text>&#xa;onLoadUsua='</xsl:text>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" >
                     <xsl:value-of select="translate(@onload, '&#xa;',' ')" />
                  </xsl:with-param>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
               <xsl:text>';&#xa;</xsl:text>
            </SCRIPT>
         </HEAD>
         <FRAMESET rows="*" frameborder="NO" border="0" framespacing="0"> 
            <FRAME name="DrMainEstatico" src="{$pHTMLEstatico}.html">
               <xsl:attribute name="scrolling">
                  <xsl:choose>
                     <xsl:when test="/PAGINA/@scrollFrame and /PAGINA/@scrollFrame='S'">yes</xsl:when>
                     <xsl:otherwise>no</xsl:otherwise>
                  </xsl:choose> 
              </xsl:attribute>
            </FRAME>
         </FRAMESET>
      </HTML>

   </xsl:template>


   <xsl:template name="PAGINA-estatico">
      <xsl:variable name="vLang" select="/PAGINA/@xml:lang"/>
      <xsl:variable name="vgPosicionCapaOcupado">
         <xsl:choose>
            <xsl:when test="/PAGINA/@xml:lang">
               <xsl:value-of select="$vgConfig/DATOSPROY/OCUPADO/CAPA[lang($vLang)]/@posicion"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="$vgConfig/DATOSPROY/OCUPADO/CAPA[1]/@posicion"/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>
      <xsl:variable name="vgCapaOcupado" select="$vgConfig/DATOSPROY/OCUPADO/CAPA[1]"/>
      <xsl:variable name="vgCapaOcupadoLang" select="$vgConfig/DATOSPROY/OCUPADO/CAPA[lang($vLang)]"/>

      <HTML>
         <HEAD>

            <META NAME="Author" CONTENT="&cia;"/>
            <META NAME="Generator" CONTENT="&druidav;"/>

            <xsl:variable name="vTxt">
               <xsl:choose>
                  <xsl:when test="@cod">
                     <xsl:call-template name="langtxt">
                        <xsl:with-param name="pCod" select="@cod"/>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="@titulo"/>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:variable>

            <TITLE>
               <xsl:value-of select="$vTxt"/>
            </TITLE>
            <xsl:if test="@estilos and string-length(@estilos)>0">
               <LINK REL="stylesheet" TYPE="text/css">
                  <xsl:attribute name="HREF">
                     <xsl:value-of select="$cssPath"/>
                     <xsl:value-of select="@estilos"/>
                  </xsl:attribute>
               </LINK>
            </xsl:if>
            <xsl:text>&#xa;</xsl:text>
            <SCRIPT>
               <xsl:text>window.moveWindowTo=window.moveTo;window.moveWindowBy=window.moveBy;&#xa;</xsl:text>

               <!-- VARIABLES PARA JAVASCRIPT -->

               <xsl:if test="$vgTrimAlEnviarText='S'">
                  <xsl:text>window.TRIM_TEXT=true;&#xa;</xsl:text>
               </xsl:if>
         
               <xsl:if test="$vgTrimAlEnviarAreaTexto='S'">
                  <xsl:text>window.TRIM_AREATEXTO=true;&#xa;</xsl:text>
               </xsl:if>

               <xsl:if test="$vgRequeridoIgnoraEspacios='S'">
                  <xsl:text>reqIgnEsp=true;&#xa;</xsl:text>
               </xsl:if>

               <xsl:text>window.tipoTooltip="</xsl:text><xsl:value-of select="$vgTipoTooltip"/><xsl:text>";&#xa;</xsl:text>
               <xsl:text>window.tooltipEstilo="</xsl:text><xsl:value-of select="$vgEstiloTooltip"/><xsl:text>";&#xa;</xsl:text>

               <xsl:if test="$vgConfig/DATOSPROY/MODIFICAR[@COMPONENTE='LABELC' and @OPCION='SiVacioQuitarEstilo']">
                  <xsl:text>window.LABC_SVQE=true;&#xa;</xsl:text>
               </xsl:if>

               <!-- esta la usamos en base.js para focaliza() -->
               <xsl:if test="$vgConfig/DATOSPROY/ALERTMODAL">
                  <xsl:text>&#xa;window.alertModal=new Object(); &#xa;</xsl:text>
                  <xsl:text>window.alertModal.ON="</xsl:text>
                  <xsl:value-of select="$vgConfig/DATOSPROY/ALERTMODAL/ON"/>
                  <xsl:text>";&#xa;</xsl:text>
                  <xsl:text>window.alertModal.drServlet="</xsl:text>
                  <xsl:value-of select="$vgConfig/DATOSPROY/PROXYSERVLET"/>
                  <xsl:text>";&#xa;</xsl:text>
                  <xsl:if test="$vgConfig/DATOSPROY/ALERTMODAL/CARACTERISTICAS">
                     <xsl:text>window.alertModal.sFeatures="</xsl:text>
                     <xsl:value-of select="$vgConfig/DATOSPROY/ALERTMODAL/CARACTERISTICAS"/>
                     <xsl:text>";&#xa;</xsl:text>
                  </xsl:if>
                  <xsl:if test="$vgConfig/DATOSPROY/ALERTMODAL/FJS">
                     <xsl:text>&#xa;window.alertModal.sFuncJS="</xsl:text><xsl:value-of select="$vgConfig/DATOSPROY/ALERTMODAL/FJS"/><xsl:text>";&#xa;</xsl:text>
                  </xsl:if>
               </xsl:if>

               <!-- esta la usamos en base.js para saber si hay que tracear por javascript -->
               <xsl:if test="$DR_DEBUG_JS='S'">
                  <xsl:text>window.top.DR_DEBUG_JS=true;&#xa;</xsl:text>
               </xsl:if>
               <xsl:if test="$DR_DEBUG_TIEMPOS='S'">
                  <xsl:text>window.drd_tiempo_inicio='</xsl:text><xsl:value-of select="$drd_tiempo_inicio"/><xsl:text>';&#xa;</xsl:text>
               </xsl:if>

            </SCRIPT>
            <xsl:text>&#xa;</xsl:text>
            <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}base.js">
               <!-- debe encontrar la etiqueta de cierre, y por esto se pone el text -->
               <xsl:text> </xsl:text>
            </SCRIPT>
            <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}d3ocupado.js">
               <xsl:text> </xsl:text>
            </SCRIPT>

            <!-- mensajes javascript del core -->
            <xsl:choose>
               <xsl:when test="/PAGINA/@xml:lang and not(/PAGINA/@xml:lang='es')">
                  <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}d3msgCore_{$vLang}.js">
                     <xsl:text> </xsl:text>
                  </SCRIPT>
               </xsl:when>
               <xsl:otherwise>
                  <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}d3msgCore.js">
                     <xsl:text> </xsl:text>
                  </SCRIPT>
               </xsl:otherwise>
            </xsl:choose>

            <!-- mensajes javascript de la aplicacion -->
           <xsl:if test="/PAGINA/@xml:lang">
               <SCRIPT TYPE="text/javascript" SRC="{$jsPath}mensajes-{$vLang}.js">
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if> 

            <!-- FALTAN JS's EN FUNCION DE LOS COMPONENTES INCLUIDOS, validaciones, etc...  ver pagina.java -->
            <xsl:if test="//BOTON">
               <SCRIPT TYPE="text/javascript">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$jsDruidaPath"/>
                     <xsl:text>boton.js</xsl:text>
                  </xsl:attribute>
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if>


            <xsl:text>&#xa;</xsl:text>
             <!-- Druida Runner -->
            <xsl:if test="@drdRunner='S'">
               <SCRIPT TYPE="text/javascript" SRC="{$jsPath}drdRunner.js">
               <!-- debe encontrar la etiqueta de cierre, y por esto se pone el text -->
               <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if> 
            <xsl:text>&#xa;</xsl:text>

            <xsl:for-each select="JS">
               <SCRIPT TYPE="text/javascript">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$jsPath"/><xsl:value-of select="@src"/>
                  </xsl:attribute>
              <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:for-each>
            <xsl:text>&#xa;</xsl:text>

            <xsl:apply-templates mode="head">
               <xsl:with-param name="nsdoc">document</xsl:with-param>
            </xsl:apply-templates>

            <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
            <xsl:call-template name="EXT.head"/>


            <xsl:if test="$pPersonalizable='S'">
               <SCRIPT TYPE="text/javascript" SRC="{$ProxyServlet}?ON=EntornoV">
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if>

            <xsl:text>&#xa;</xsl:text>
            <STYLE TYPE="text/css">

                  <xsl:value-of select="ESTILO"/>

                  <xsl:text>
#DRUIDA {position:absolute;left:0;top:0;visibility:hidden;}</xsl:text>
                  <xsl:apply-templates mode="estilo">
                     <xsl:with-param name="nsdoc">document</xsl:with-param>
                  </xsl:apply-templates>

            <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
            <xsl:call-template name="EXT.estilo"/>

                  <xsl:text>&#xa;&#xa;</xsl:text>
            </STYLE>
            <xsl:text>&#xa;</xsl:text>

            <SCRIPT TYPE="text/javascript">
<!--              <xsl:comment> -->

                  <!-- El contenido de JAVASCRIPT dbe estar incluido en una instruccion de proceso <![CDATA[...]]> -->
<!--                  <xsl:value-of select="PAGINA/JAVASCRIPT/." disable-output-escaping="yes"/> -->
                  <xsl:value-of select="JAVASCRIPT/."/>
<xsl:text>
function getArco () { return '</xsl:text><xsl:value-of select="$pDruidaArcoIn"/><xsl:text>';}
</xsl:text>
<xsl:text>
var ArcosSalida = new Array (</xsl:text><xsl:value-of select="$pDruidaArcosOut"/><xsl:text>);
</xsl:text>
<xsl:text>
function getPlace () { return '</xsl:text><xsl:value-of select="$pDruidaPlace"/><xsl:text>';}
</xsl:text>

<xsl:text>
function nombrePagina () { return '</xsl:text><xsl:value-of select="@nombre"/><xsl:text>';}
</xsl:text>

                  <xsl:if test="/PAGINA/@xml:lang">
                     <xsl:text>&#xa;function DrdIdioma () { return '</xsl:text><xsl:value-of select="/PAGINA/@xml:lang"/><xsl:text>';}&#xa;</xsl:text>
                  </xsl:if>
<xsl:text>
function DrdImgPath () { return '</xsl:text><xsl:call-template name="DrdImgPath"/><xsl:text>';}&#xa;</xsl:text>

                  <xsl:if test="@msgle!=''">
                     <xsl:text>
window.defaultStatus='</xsl:text>
                     <xsl:value-of select="@msgle" disable-output-escaping="yes"/>
                     <xsl:text>';</xsl:text>
                  </xsl:if>

                  <xsl:text>
DRUIDA=new Object();DRUIDA.NS='document.DRUIDA.document';DRUIDA.ID='';DRUIDA.TC='Label';</xsl:text>
                  <xsl:apply-templates mode="script">
                     <xsl:with-param name="nsdoc">document</xsl:with-param>
                  </xsl:apply-templates>

                  <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
                  <xsl:call-template name="EXT.script"/>

                  <!-- Control back estatico, array de componentes -->
<xsl:text>
var d3_componentes = new Array();</xsl:text>

                  <!-- init y finit  -->

   <xsl:text>&#xa;function drdOnLoad() {</xsl:text>

   <!-- si en el globales hay algo así:  
        <OCUPADO> ...   
             <OCULTAR OPCION="OnLoad"/> ... 
             </OCUPADO> 
        cierro el onload del opener -->
   <xsl:if test="$vgConfig/DATOSPROY/OCUPADO/OCULTAR/@OPCION and translate($vgConfig/DATOSPROY/OCUPADO/OCULTAR/@OPCION ,'abcdefghijklmnñopqrstuvwxyz','ABCDEFGHIJKLMNÑOPQRSTUVWXYZ') = 'ONLOAD'">
      DrdCierraCargandoDeOpener();
   </xsl:if>



   <!-- TRACEO JS -->
   <xsl:if test="$DR_DEBUG_JS='S'">
      <xsl:text>DrdGuardaTraza("EV-DRDJS, cargada &lt;PAGINA nombre=\""+nombrePagina()+"\"&gt;, evento onload");&#xa;</xsl:text>
   </xsl:if>
   <!-- /TRACEO JS -->

   <xsl:apply-templates mode="init"/>

   <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
   <xsl:call-template name="EXT.init"/>

   <xsl:text>}&#xa;</xsl:text>

var d3_PS='<xsl:value-of select="$ProxyServlet"/>';

window.requeridoS='<xsl:value-of select="$vgColReq"/>';
window.requeridoN='<xsl:value-of select="$vgColNoReq"/>';
window.deshabilitadoColor='<xsl:value-of select="$vgColDeshabilitados"/>';
<xsl:if test="string-length($vgDisableFontSize)>0">
window.disableFontSize="<xsl:value-of select="$vgDisableFontSize"/>";
</xsl:if> 
<xsl:if test="string-length($vgEnableFontSize)>0">
window.enableFontSize="<xsl:value-of select="$vgEnableFontSize"/>";
</xsl:if> 

if (window.labelRC==null || window.labelRC=='') {window.labelRC="<xsl:value-of select="$vglabelRC"/>";}

   <!-- Con estas variables determino si hay que mostrar la capa de ocupado (el nombre no esta muy bien elegido) -->
   <xsl:if test="$vOcupadoAsignarJS = 'S'">
window.oculta_asignar=true;
   </xsl:if> 
   <xsl:if test="$vOcupadoPaginado = 'S'">
window.oculta_paginado=true;
   </xsl:if> 
   <xsl:if test="$vOcupadoFrmCOculto = 'S'">
window.oculta_frmOculto=true;
   </xsl:if> 
   <xsl:if test="$vOcupadoFichero='S'">
window.ocupado_fichero=true;
   </xsl:if>
   <xsl:if test="$vOcupadoEnvia='S'">
window.ocupado_envia=true;
   </xsl:if>
   <xsl:if test="$vOcupadoLista='S'">
window.ocupado_lista=true;
   </xsl:if>
   <xsl:if test="$vOcupadoBloquea='S'">
window.ocupado_bloquea=true;
   </xsl:if>

   <xsl:if test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Bloquea']/ONCLICK">
      <xsl:text>window.ocupado_bloquea_onclick='</xsl:text>
      <xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Bloquea']/ONCLICK"/><xsl:with-param name="caracter">'</xsl:with-param></xsl:call-template>
      <xsl:text>';</xsl:text>
   </xsl:if>
   
   <!-- posicion de la capa ocupado -->
   <xsl:variable name="vPos">
      <xsl:choose>
         <xsl:when test="not ($vgPosicionCapaOcupado) or $vgPosicionCapaOcupado=''">
            <xsl:text>C</xsl:text>
         </xsl:when>
         <xsl:when test="$vgPosicionCapaOcupado != 'SI' and $vgPosicionCapaOcupado != 'SD' and $vgPosicionCapaOcupado != 'II' and $vgPosicionCapaOcupado != 'ID'">
            <xsl:text>C</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vgPosicionCapaOcupado"/> 
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

var d3ocupado_general='<xsl:value-of select="$vPos"/>';

<xsl:text>
</xsl:text>
            </SCRIPT>
<xsl:text>
</xsl:text>
         </HEAD>
            <BODY LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
               <xsl:attribute name="STYLE">
                  <xsl:if test="@colorf!=''">
                     <xsl:text> background-color:</xsl:text>
                     <xsl:value-of select="@colorf"/>
                     <xsl:text>;</xsl:text>
                  </xsl:if>
                  <xsl:if test="@imagenf!=''">
                     <xsl:text>background-image:url(</xsl:text>
                     <xsl:value-of select="$vgImgPath"/>
                     <xsl:value-of select="@imagenf"/>
                     <xsl:text>); </xsl:text>
                  </xsl:if>
                  <xsl:if test="@repimagenf!=''">
                     <xsl:text>background-repeat:</xsl:text>
                     <xsl:choose>      <!-- repeat por defecto = "N" -->
                       <xsl:when test="@repimagenf!='N'"><xsl:text>repeat</xsl:text></xsl:when>
                       <xsl:otherwise><xsl:text>no-repeat</xsl:text></xsl:otherwise>
                     </xsl:choose>
                  </xsl:if>
                </xsl:attribute>

               <xsl:attribute name="onLoad">

                  <xsl:if test="$DR_DEBUG_TIEMPOS='S'">DrdTrazasTiempoInicioOnload();</xsl:if>

                  <xsl:if test="$pGeneroHTML='S'">
                     <xsl:text>if(oculta_asignar){d3ocupado_ver('d3general',d3ocupado_general);}</xsl:text>
                  </xsl:if>

                  <xsl:text>drdOnLoad();</xsl:text>

                  <xsl:choose>
                     <xsl:when test="$pGeneroHTML='S'">
                        <xsl:text>parent.drdSets(document);eval(parent.onLoadUsua);</xsl:text>
                     </xsl:when>
                     <xsl:otherwise>
                        <xsl:value-of select="@onload" />
                     </xsl:otherwise>
                  </xsl:choose> 

                  <!--
                  <xsl:if test="$pGeneroHTML='S'">
                     <xsl:text>parent.drdSets(document);</xsl:text>
                  </xsl:if>
                  <xsl:value-of select="@onload" />
                  -->

	               <xsl:text>;loadValoresPagina();</xsl:text>

		            <xsl:value-of select="@onback" />
                  
                  <!--
                  <xsl:if test="$pDinamico='S' and string-length($pHTMLEstatico)=0">
   	               <xsl:text>;parent.drdSets();</xsl:text>
                  </xsl:if>
                  -->
                  
                  <xsl:if test="$DR_DEBUG_TIEMPOS='S'">DrdTrazasTiempoFinOnload();</xsl:if>

               </xsl:attribute>
               <xsl:attribute name="onUnload">
                  <!-- TRACEO JS 
                  <xsl:if test="$DR_DEBUG_JS='S'">
                     <xsl:text>DrdGuardaTraza("EV-DRDJS, se cierra la ventana, evento onunload");&#xa;</xsl:text>
                  </xsl:if>
                   /TRACEO JS -->
                  <xsl:value-of select="@onunload"/>
	            </xsl:attribute>

               <DIV ID="DRUIDA">
			   
               <IMG src="{$imgTranspPath}"  height="1">
                     <xsl:attribute name="width">
                        <xsl:text>100%</xsl:text>
                     </xsl:attribute> 
                     <xsl:attribute name="height">
                        <xsl:text>100%</xsl:text>
                     </xsl:attribute> 
               </IMG>
			   <xsl:text> </xsl:text>
			   </DIV>
               <DIV ID="tooltipDiv" style="position:absolute;visibility:hidden;z-index:1100"><xsl:text> </xsl:text></DIV>


               <!-- Capa a mostrar en operaciones costosas -->
               <DIV ID="d3ocupadod3general" style="position:absolute;visibility:hidden;z-index:1000">
                  <xsl:choose>
                     <xsl:when test="/PAGINA/@xml:lang">
                              <xsl:apply-templates select="$vgCapaOcupadoLang/*"/>
                     </xsl:when>
                     <xsl:otherwise>
                              <xsl:apply-templates select="$vgCapaOcupado/*"/>
                     </xsl:otherwise>
                  </xsl:choose> 
               </DIV>      

               
               <xsl:apply-templates mode="body">
                  <xsl:with-param name="nsdoc">document</xsl:with-param>
               </xsl:apply-templates>

               <!-- extensibilidad del core por parte del proyecto, ver drd30_extensible.xsl -->
               <xsl:call-template name="EXT.body"/>

               <xsl:for-each select="//FORMULARIO">
                  <xsl:call-template name="FORMULARIOFINAL"/>
               </xsl:for-each>
               <xsl:for-each select="//PAGINADO">
                  <xsl:call-template name="FORMULARIOFINALPAGINADO"/>
               </xsl:for-each>
               <xsl:for-each select="//OCUPADO">
                  <xsl:call-template name="OCUPADOFINAL"/>
               </xsl:for-each>

               <FORM NAME="d3canal_form" METHOD="post" ACTION="{$ProxyServlet}?ON=ObjetoCanal">
                  <INPUT TYPE="hidden" NAME="d3canal_componente"/>
                  <INPUT TYPE="hidden" NAME="d3canal_nombre"/>
                  <INPUT TYPE="hidden" NAME="d3canal_conector"/>
                  <INPUT TYPE="hidden" NAME="d3canal_element"/>
                  <INPUT TYPE="hidden" NAME="d3canal_ID"/>
                  <INPUT TYPE="hidden" NAME="d3canal_control"/>
                  <INPUT TYPE="hidden" NAME="d3canal_excepcion"/>
                  <INPUT TYPE="hidden" NAME="d3canal_alert"/>
               </FORM>

               <xsl:if test="$DR_DEBUG_TIEMPOS='S'">
                  <FORM NAME="formulario_debug_tiempos" METHOD="post" ACTION="{$ProxyServlet}?ON={$drd_tiempo_servlet}">
                     <INPUT TYPE="hidden" NAME="drd_cod_al" value="{$drd_cod_al}"/>
                     <INPUT TYPE="hidden" NAME="drd_comando" value="{$drd_comando}"/>
                     <INPUT TYPE="hidden" NAME="drd_tiempo_total"/>
                  </FORM>
               </xsl:if>

            </BODY>
      </HTML>
   </xsl:template>


   <!-- Plantilla para el elemento raiz -->

   <xsl:template match="/FICHERO">
      <xsl:variable name="vSep">
         <xsl:choose>
            <xsl:when test="@separador='TAB'"><xsl:text>&#9;</xsl:text></xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="@separador"/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>
         
      <xsl:for-each select="ROWSET/ROW">

         <xsl:choose>

            <!-- Si solo tengo una fila con un CAMPO con un atributo TIPO='FICHERO'; 
                 saco el fichero decodificado y sin escapar la salida para que quede tal cual -->
            <xsl:when test="count(CAMPO)=1 and CAMPO[1]/@TIPO='FICHERO'">
               <xsl:variable name="vFich" select="CAMPO[1]"/>
               <xsl:value-of select="drdencb64:decodeToString($vFich)" disable-output-escaping="yes"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:for-each select="CAMPO">
                  <xsl:value-of select="." disable-output-escaping="yes"/>
                  <xsl:if test="position() != last()">
                     <xsl:value-of select="$vSep"/>
                  </xsl:if> 
               </xsl:for-each> 
               <xsl:text>&#xa;</xsl:text>
            </xsl:otherwise>
         </xsl:choose>
         

      </xsl:for-each> 

   </xsl:template>

</xsl:stylesheet >

