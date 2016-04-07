<?xml version="1.0" encoding="ISO-8859-1"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
	xmlns:drdcambia="http://xml.apache.org/xalan/java/es.indra.druida.util.DruidaUtils"
	xmlns:drdencb64="http://xml.apache.org/xalan/java/es/indra/druida/util/DruidaEncodingBase64"
	exclude-result-prefixes="drdcambia drdencb64">

   <xsl:output method="html" indent="no" encoding="ISO-8859-1"/>

   
   <xsl:variable name="cssPath" select="document('../config/globales.xml')/DATOSPROY/CSSPATH"/>
   <xsl:variable name="jsPath" select="document('../config/globales.xml')/DATOSPROY/JSPATH"/>
   <xsl:variable name="imgPath" select="document('../config/globales.xml')/DATOSPROY/IMGPATH"/>
   <xsl:variable name="drdPath" select="document('../config/globales.xml')/DATOSPROY/DRDPATH"/>
   <xsl:variable name="ProxyServlet" select="document('../config/globales.xml')/DATOSPROY/PROXYSERVLET"/>
   <xsl:variable name="imgTransparente" select="document('../config/globales.xml')/DATOSPROY/IMAGENES/ESPACIADO/ICONO"/>

   <xsl:variable name="imgCampoRequerido" select="document('../config/globales.xml')/DATOSPROY/IMAGENES/CAMPOREQ/ICONO"/>
   <xsl:variable name="txtCampoRequerido" select="document('../config/globales.xml')/DATOSPROY/IMAGENES/CAMPOREQ/TEXTO"/>

   
   <xsl:variable name="vgConfig" select="document('../config/globales.xml')"/>
   <!--	<xsl:variable name="vgTextos" select="document('../config/idiomas.xml')"/>	-->
   

   <xsl:variable name="vgCtexto" select="$vgConfig/DATOSPROY/VALIDACIONES/CTEXTO"/>
   <xsl:variable name="vgTooltip" select="$vgConfig/DATOSPROY/TIPOTOOLTIP"/>

   
   <xsl:variable name="mostrar_comentarios">N</xsl:variable>
   <xsl:variable name="debug">N</xsl:variable>

   <!--Agregado Gaston Acevedo -->
   <xsl:include href="SICC_Validaciones.xsl"/>   
   <xsl:template name="EXT.init">
	<!--Menu secundario-->
	&#xa;try{
		document.onkeydown = fnCheckKeys;
		document.onhelp=fnShowHelp;
	}catch(e){
		;
	}&#xa;
   </xsl:template><xsl:template name="EXT.head">
		<!--Validaciones-->
	<xsl:if test="//VALIDACION">
		<xsl:call-template name="VALIDACION">
			<xsl:with-param name="nodo" select="//VALIDACION"></xsl:with-param>
		</xsl:call-template>
	</xsl:if>
   </xsl:template>
   <!--************************-->
   <xsl:template name="EXT.estilo">
   </xsl:template><xsl:template name="EXT.script">
   </xsl:template><xsl:template name="EXT.body">
   </xsl:template><xsl:template name="EXT.form">
   </xsl:template><xsl:template name="EXT.dinamico">
   </xsl:template><xsl:param name="vDruidaNavegador">Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; xxxxxxx)</xsl:param><xsl:param name="pDruidaArcoIn">null</xsl:param><xsl:param name="pDruidaArcosOut"/><xsl:param name="pDruidaTipoArcosOut"/><xsl:param name="drd_estado"/><xsl:param name="drd_evento"/><xsl:param name="drd_net"/><xsl:param name="pPersonalizable">N</xsl:param><xsl:param name="pDruidaPlace">null</xsl:param><xsl:param name="DR_DEBUG_JS">N</xsl:param><xsl:param name="DR_DEBUG_TIEMPOS">N</xsl:param><xsl:param name="drd_tiempo_inicio"/><xsl:param name="drd_cod_al"/><xsl:param name="drd_comando"/><xsl:param name="drd_perfil"/><xsl:param name="drd_pagina"/><xsl:param name="pDinamico"/><xsl:param name="pHTMLEstatico"/><xsl:param name="pJS"/><xsl:param name="pGeneroHTML"/><xsl:param name="pLoModal"/><xsl:param name="pLoModalFeatures"/><xsl:param name="pLoModalUrl"/><xsl:variable name="vgMultiIdioma" select="$vgConfig/DATOSPROY/MULTIIDIOMA"/><xsl:variable name="vgAlertModal" select="$vgConfig/DATOSPROY/ALERTMODAL"/><xsl:variable name="vgModificar" select="$vgConfig/DATOSPROY/MODIFICAR"/><xsl:variable name="vgOcupado" select="$vgConfig/DATOSPROY/OCUPADO"/><xsl:variable name="vgValidTextArea" select="$vgConfig/DATOSPROY/VALIDACIONES/TEXTAREA"/><xsl:variable name="vgOnKupTextArea" select="$vgConfig/DATOSPROY/EVENTO_ONKEYUP/TEXTAREA"/><xsl:variable name="vgForzarTooltip" select="$vgConfig/DATOSPROY/FORZARTOOLTIP"/><xsl:variable name="vgOnKupCtexto" select="$vgConfig/DATOSPROY/EVENTO_ONKEYUP/CTEXTO"/><xsl:variable name="vgOnChangeCtexto" select="$vgConfig/DATOSPROY/EVENTO_ONCHANGE/CTEXTO"/><xsl:variable name="vgCtexto" select="$vgConfig/DATOSPROY/VALIDACIONES/CTEXTO"/><xsl:variable name="vgPetri">
      <xsl:choose>
        <xsl:when test="$pDruidaArcosOut != 'null'">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose>
   </xsl:variable><xsl:variable name="vNavegador">
      <xsl:choose>
        <xsl:when test="contains($vDruidaNavegador,'MSIE')">IE</xsl:when>
        <xsl:otherwise>NS</xsl:otherwise>
      </xsl:choose>
   </xsl:variable><xsl:variable name="compatibleNt4">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/COMPATIBLE_NT4X">
            <xsl:value-of select="$vgConfig/DATOSPROY/COMPATIBLE_NT4X"/>
         </xsl:when>
         <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose>
   </xsl:variable><xsl:variable name="vgImgPath">
      <xsl:call-template name="DrdImgPath"/>
   </xsl:variable><xsl:variable name="imgTranspPath">
      <xsl:value-of select="$vgImgPath"/>
      <xsl:choose>
         
         
         <xsl:when test="boolean($imgTransparente)">
            <xsl:value-of select="$imgTransparente"/>
         </xsl:when>
         <xsl:otherwise>transparente.gif</xsl:otherwise>
      </xsl:choose>
   </xsl:variable><xsl:variable name="imgDruidaPath">
      <xsl:value-of select="concat($drdPath,'img/')"/>
    </xsl:variable><xsl:variable name="jsDruidaPath">
      <xsl:value-of select="concat($drdPath,'js/')"/>
    </xsl:variable><xsl:variable name="rutaEntV">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/RUTAENTORNOV">
            <xsl:value-of select="$vgConfig/DATOSPROY/RUTAENTORNOV"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$jsDruidaPath"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:variable><xsl:variable name="vOcupadoAsignarJS">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='AsignarJS']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vOcupadoPaginado">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='Paginado']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vOcupadoFrmCOculto">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='FrmCOculto']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vOcupadoFichero">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='Fichero']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vOcupadoEnvia">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='Envia']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vOcupadoLista">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='Lista']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vOcupadoBloquea">
      <xsl:choose>
        <xsl:when test="$vgOcupado/MOSTRAR[@OPCION='Bloquea']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgScrollResize" select="$vgConfig/DATOSPROY/SCROLLRESIZE"/><xsl:variable name="vgColReadOnly" select="$vgConfig/DATOSPROY/COLORREADONLY"/><xsl:variable name="vgColReq" select="$vgConfig/DATOSPROY/COLORCREQ"/><xsl:variable name="vgColNoReq" select="$vgConfig/DATOSPROY/COLORCNOREQ"/><xsl:variable name="vgColDeshabilitados" select="$vgConfig/DATOSPROY/COLORCDES"/><xsl:variable name="vgDisableFontSize" select="$vgConfig/DATOSPROY/DISABLEFONTSIZE"/><xsl:variable name="vgEnableFontSize" select="$vgConfig/DATOSPROY/ENABLEFONTSIZE"/><xsl:variable name="vgFormElementID" select="$vgConfig/DATOSPROY/FORMELEMENTID"/><xsl:variable name="vgRadioCheckColorOnText" select="$vgConfig/DATOSPROY/RADIOCHECKCOLORONTEXT"/><xsl:variable name="vglabelRC" select="$vgConfig/DATOSPROY/LABELRC"/><xsl:variable name="vLang" select="/PAGINA/@xml:lang"/><xsl:variable name="vLangExist" select="boolean(/PAGINA/@xml:lang)"/><xsl:variable name="vgTxtCampoRequerido">
      <xsl:choose>
         <xsl:when test="$vLangExist">
            <xsl:value-of select="$vgConfig/DATOSPROY/IMAGENES[lang($vLang)]/CAMPOREQ/TEXTO"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vgConfig/DATOSPROY/IMAGENES/CAMPOREQ/TEXTO"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgEstiloTooltip">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/TOOLTIP">
            <xsl:value-of select="$vgConfig/DATOSPROY/TOOLTIP"/>
         </xsl:when>
         <xsl:otherwise>background-color:#FFFFDF;font-family:arial;font-size:10pt</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgTipoTooltip">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/TIPOTOOLTIP">
            <xsl:value-of select="$vgConfig/DATOSPROY/TIPOTOOLTIP"/>
         </xsl:when>
         <xsl:otherwise/>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgRequeridoIgnoraEspacios">
      <xsl:choose>
        <xsl:when test="$vgModificar[@COMPONENTE='VALIDACIONES' and @OPCION='requeridoIgnoraEspacios']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgPintadoSimplificado">
      <xsl:choose>
        <xsl:when test="$vgModificar[@COMPONENTE='LISTAEDITABLE' and @OPCION='pintadoSimplificado']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgTrimAlEnviarText">
      <xsl:choose>
        <xsl:when test="$vgModificar[@COMPONENTE='TEXT' and @OPCION='trimAlEnviar']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgTrimAlEnviarAreaTexto">
      <xsl:choose>
        <xsl:when test="$vgModificar[@COMPONENTE='AREATEXTO' and @OPCION='trimAlEnviar']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgTipoAsignarJs">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/TIPOASIGNARJS"><xsl:value-of select="$vgConfig/DATOSPROY/TIPOASIGNARJS/text()"/></xsl:when>
        <xsl:otherwise/>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="frameCache">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/RUTA_FRAME_CACHE"><xsl:value-of select="$vgConfig/DATOSPROY/RUTA_FRAME_CACHE"/></xsl:when>
         <xsl:otherwise/>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="noHacerNormalizeSpace">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/NORMALIZAR_ESPACIOS and $vgConfig/DATOSPROY/NORMALIZAR_ESPACIOS='N'">S</xsl:when>
         <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="vgQuieroDruidaBack">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/DRUIDABACK and $vgConfig/DATOSPROY/DRUIDABACK='S'">S</xsl:when>
         <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable><xsl:variable name="nsdoc-local">N</xsl:variable><xsl:template match="LABEL" mode="head">
   </xsl:template><xsl:template match="LABEL" mode="estilo">
   <xsl:text>
</xsl:text>
         
            
            <xsl:text>#</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>{</xsl:text>
            <xsl:text>position:absolute;left:</xsl:text>
            <xsl:value-of select="@x"/>
            <xsl:text>;top:</xsl:text>
            <xsl:value-of select="@y"/>
            <xsl:text>;}</xsl:text>
   </xsl:template><xsl:template match="LABEL" mode="script">
      
      <xsl:variable name="vLink">
         <xsl:choose>
            <xsl:when test="@enlace">
               <xsl:text>"</xsl:text><xsl:value-of select="@enlace"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>=new drdLabel('</xsl:text>

      <xsl:value-of select="@id"/>
      <xsl:text>',</xsl:text>
      <xsl:call-template name="label.tooltip2.script"/>
      <xsl:text>,</xsl:text>
      <xsl:value-of select="$vLink"/>
      <xsl:text>);</xsl:text>

      
      <xsl:if test="@enviaroculto='S'">
         <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>TC="Hidden";</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>.enviar='</xsl:text><xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>';
      </xsl:if> 

   </xsl:template><xsl:template match="LABEL" mode="init">
      
      <xsl:if test="$vgQuieroDruidaBack='S'">
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
      <xsl:if test="not(@enlace) or string-length(@enlace)=0">
         <xsl:text>txt_to('</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:choose>
            <xsl:when test="@cod and string-length(normalize-space(@cod)) &gt; 0">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose> 
         <xsl:text>');</xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="LABEL" mode="body">
      <xsl:choose>
         <xsl:when test="@enlace!=''">
            <xsl:call-template name="LABEL-BODY-ENLACE"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="LABEL-BODY-NORMAL"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template name="LABEL-BODY-NORMAL">

      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod and string-length(normalize-space(@cod))&gt;0">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

         <xsl:choose>
            <xsl:when test="@id!=''"> 
               <SPAN>
                  <xsl:attribute name="ID">
                     <xsl:value-of select="@id"/>
                  </xsl:attribute>


                  <xsl:value-of select="$vTxt"/>

               </SPAN>
            </xsl:when>
            <xsl:otherwise>

                  <xsl:value-of select="$vTxt"/>
            </xsl:otherwise>
         </xsl:choose>
      </DIV>
   </xsl:template><xsl:template name="LABEL-BODY-ENLACE">
      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod and string-length(normalize-space(@cod)) &gt; 0">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <DIV ID="{@nombre}">

         
         <A HREF="{@enlace}">
            <xsl:if test="@destino!=''">
               <xsl:attribute name="TARGET">
                  <xsl:value-of select="@destino"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:choose>
               <xsl:when test="@id!=''"> 
                  <SPAN>
                     <xsl:attribute name="ID">
                        <xsl:value-of select="@id"/>
                     </xsl:attribute>
                     <xsl:value-of select="$vTxt"/>
                  </SPAN>
               </xsl:when>
               <xsl:otherwise>
                     <xsl:value-of select="$vTxt"/>
               </xsl:otherwise>
            </xsl:choose>
         </A>
      </DIV>
   </xsl:template><xsl:template match="LABEL" mode="form">
      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod and string-length(normalize-space(@cod)) &gt; 0">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>
      
      <xsl:if test="@enviaroculto='S'">
         <xsl:value-of select="'&#xA;'"/>
         <INPUT TYPE="hidden">
            <xsl:attribute name="NAME">
               <xsl:value-of select="@nombre"/>
            </xsl:attribute>
            <xsl:attribute name="VALUE">
               <xsl:value-of select="$vTxt"/>
            </xsl:attribute>
         </INPUT>
      </xsl:if>
   </xsl:template><xsl:template name="LABEL.enlace">
      <xsl:param name="vTxt"/>
      <A HREF="{@enlace}">
         <xsl:if test="@destino!=''">
            <xsl:attribute name="TARGET">
               <xsl:value-of select="@destino"/>
            </xsl:attribute>
         </xsl:if>
         <xsl:choose>
            <xsl:when test="@id!=''"> 
               <SPAN>
                  <xsl:attribute name="ID">
                     <xsl:value-of select="@id"/>
                  </xsl:attribute>
                  <xsl:value-of select="$vTxt"/>
               </SPAN>
            </xsl:when>
            <xsl:otherwise>
                  <xsl:value-of select="$vTxt"/>
            </xsl:otherwise>
         </xsl:choose>
      </A>
   </xsl:template><xsl:template match="LABELC" mode="head">
   </xsl:template><xsl:template match="LABELC" mode="estilo">
      <xsl:text>
</xsl:text>

   
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:relative;</xsl:text>
      <xsl:if test="@ancho and not(@ancho='') and @alto and not(@alto='')">
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>;height:</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>;</xsl:text>
         <xsl:text>clip:rect(0,</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>,0);</xsl:text>
      </xsl:if>
      <xsl:text>}</xsl:text>
      <xsl:text>
</xsl:text>
      <xsl:if test="@ancho and not(@ancho='') and @alto and not(@alto='')">
         <xsl:text>#</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text> {</xsl:text>
         <xsl:text>position:absolute;</xsl:text>
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>;height:</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>;clip:rect(0,</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>,0);</xsl:text>
      </xsl:if>
      <xsl:text>}</xsl:text>

   </xsl:template><xsl:template match="LABELC" mode="script">
     

      

      <xsl:variable name="vLink">
         <xsl:choose>
            <xsl:when test="@enlace">
               <xsl:text>"</xsl:text><xsl:value-of select="@enlace"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>=new drdLabelC('</xsl:text>

      
      <xsl:choose>
         <xsl:when test="@id and not(string-length(@id)=0)"><xsl:value-of select="@id"/></xsl:when> 
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="name(..)='td' or name(..)='TD' or name(..)='Td' or name(..)='tD'">
                  <xsl:choose>
                     <xsl:when test="../@class"><xsl:value-of select="../@class"/></xsl:when>
                     <xsl:when test="../@CLASS"><xsl:value-of select="../@CLASS"/></xsl:when>
                     <xsl:otherwise/>
                  </xsl:choose>
               </xsl:when>
               <xsl:when test="name(..)='COL'">
                  <xsl:choose>
                     <xsl:when test="../@id"><xsl:value-of select="../@id"/></xsl:when>
                     <xsl:when test="../@ID"><xsl:value-of select="../@ID"/></xsl:when>
                     <xsl:otherwise/>
                  </xsl:choose>
               </xsl:when>
               <xsl:otherwise/>
            </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>','</xsl:text>
      
      <xsl:choose>
         <xsl:when test="@ancho and not(@ancho='')"><xsl:value-of select="@ancho"/></xsl:when> 
         <xsl:otherwise>0</xsl:otherwise>
      </xsl:choose>
      <xsl:text>','</xsl:text>
      
      <xsl:choose>
         <xsl:when test="@alto and not(@alto='')"><xsl:value-of select="@alto"/></xsl:when> 
         <xsl:otherwise>0</xsl:otherwise>
      </xsl:choose>
      <xsl:text>',</xsl:text>
      <xsl:call-template name="label.tooltip2.script"/>
      <xsl:text>,</xsl:text>
      <xsl:value-of select="$vLink"/>
      <xsl:text>);</xsl:text>

      
      <xsl:if test="@enviaroculto='S'">
         <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>TC="Hidden";</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>.enviar='</xsl:text><xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>';
      </xsl:if> 

   </xsl:template><xsl:template match="LABELC" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:text>
DrMainEstatico.txt_to('</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:call-template name="escapa">
             <xsl:with-param name="text" select="normalize-space(translate(@valor, '&#xA;',' '))"/>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="LABELC" mode="init">
      
      <xsl:if test="$vgQuieroDruidaBack='S'">
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>

         <xsl:variable name="vTxt">
            <xsl:call-template name="SetTxtComponente"/>
         </xsl:variable>

         <xsl:text>txt_to('</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="$vTxt"/>
         <xsl:text>');</xsl:text>

      
   </xsl:template><xsl:template match="LABELC" mode="body">
      <xsl:variable name="vTxt">
         <xsl:call-template name="SetTxtComponente.i10n"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@enlace and string-length(@enlace)&gt;0">
            <xsl:call-template name="LABELC-BODY-ENLACE">
               <xsl:with-param name="pTexto" select="$vTxt"/>
            </xsl:call-template>               
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="LABELC-BODY-NORMAL">
               <xsl:with-param name="pTexto" select="$vTxt"/>
            </xsl:call-template>               
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template name="LABELC-BODY-NORMAL">
      <xsl:param name="pTexto"/>
      <DIV ID="{concat(@nombre,'Div')}">

         <DIV ID="{@nombre}">

            <xsl:choose>
               <xsl:when test="@id!=''"> 
                  <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0">
                     <TR>
                        <TD ID="{@id}">
                           <xsl:if test="@ancho">
                              <xsl:attribute name="WIDTH">
                                 <xsl:value-of select="@ancho"/>
                              </xsl:attribute>
                           </xsl:if>
                           <xsl:if test="not(@ancho)">
                              <xsl:attribute name="nowrap"> </xsl:attribute>
                           </xsl:if>
                           <xsl:if test="@alto">
                              <xsl:attribute name="HEIGHT">
                                 <xsl:value-of select="@alto"/>
                              </xsl:attribute>
                           </xsl:if>
                           <xsl:value-of select="$pTexto"/>
                        </TD>
                     </TR>
                  </TABLE>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$pTexto"/>
               </xsl:otherwise>
            </xsl:choose>
         </DIV>
         
         
         <xsl:variable name="vCont" select="@filas - 1"/>
         <xsl:call-template name="LABELCFILAS">
            <xsl:with-param name="vCont" select="$vCont"/>
         </xsl:call-template>

      </DIV>

   </xsl:template><xsl:template name="LABELC-BODY-ENLACE">
      <xsl:param name="pTexto"/>

      <DIV ID="{concat(@nombre,'Div')}">

         <DIV ID="{@nombre}">

            <xsl:choose>
               <xsl:when test="@id!=''"> 
                  <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0">
                     <TR>
                        <TD ID="{@id}">
                           <xsl:if test="@ancho">
                              <xsl:attribute name="WIDTH">
                                 <xsl:value-of select="@ancho"/>
                              </xsl:attribute>
                           </xsl:if>
                           <xsl:if test="@alto">
                              <xsl:attribute name="HEIGHT">
                                 <xsl:value-of select="@alto"/>
                              </xsl:attribute>
                           </xsl:if>


                              <xsl:call-template name="LABEL.enlace">
                                 <xsl:with-param name="vTxt" select="$pTexto"/>
                              </xsl:call-template>
                        
                        
                        </TD>
                     </TR>
                  </TABLE>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="LABEL.enlace">
                     <xsl:with-param name="vTxt" select="$pTexto"/>
                  </xsl:call-template>
               </xsl:otherwise>
            </xsl:choose>
         </DIV>
         
         
         <xsl:variable name="vCont" select="@filas - 1"/>
         <xsl:call-template name="LABELCFILAS">
            <xsl:with-param name="vCont" select="$vCont"/>
         </xsl:call-template>

      </DIV>

   </xsl:template><xsl:template name="LABELCFILAS">
      <xsl:param name="vCont"/>
      <xsl:if test="$vCont &gt; 0">
         <BR/>
         
         <xsl:call-template name="LABELCFILAS">
            <xsl:with-param name="vCont" select="$vCont - 1"/>
         </xsl:call-template>
      </xsl:if>
   </xsl:template><xsl:template match="LABELC" mode="form">
      <xsl:variable name="vTxt">
         <xsl:call-template name="SetTxtComponente"/>
      </xsl:variable>

      
      <xsl:if test="@enviaroculto='S'">
         <xsl:value-of select="'&#xA;'"/>
         <INPUT TYPE="hidden">
            <xsl:attribute name="NAME">
               <xsl:value-of select="@nombre"/>
            </xsl:attribute>
            <xsl:attribute name="VALUE">
               <xsl:value-of select="$vTxt"/>
         
            </xsl:attribute>
         </INPUT>
      </xsl:if> 
   </xsl:template><xsl:template match="LABELTBL" mode="head">
   </xsl:template><xsl:template match="LABELTBL" mode="estilo">
<xsl:text>
</xsl:text>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="LABELTBL" mode="script">
      <xsl:apply-templates mode="script"/>
   </xsl:template><xsl:template match="LABELTBL" mode="body">

      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>


      <xsl:choose>
         <xsl:when test="enlace!=''">
            
            <A>
               <xsl:attribute name="HREF">
                  <xsl:value-of select="@enlace"/>
               </xsl:attribute>
               <xsl:if test="@destino!=''">
                  <xsl:attribute name="TARGET">
                     <xsl:value-of select="@destino"/>
                  </xsl:attribute>
               </xsl:if>

               <xsl:if test="@id!=''"> 
                  <xsl:attribute name="ID">
                     <xsl:value-of select="@id"/>
                  </xsl:attribute>
               </xsl:if>
               <xsl:value-of select="$vTxt"/>
            </A>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vTxt"/>
         </xsl:otherwise>
      </xsl:choose>



   </xsl:template><xsl:template match="BOTON" mode="head">
      
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="BOTON" mode="estilo">
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
   </xsl:template><xsl:template match="BOTON" mode="script">
      
      <xsl:choose>
         <xsl:when test="@tipo != 'html'">
            <xsl:call-template name="BOTONscript_druida">
               
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONscript_nativo">
              
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose> 
      
      <xsl:apply-templates mode="script"/>

   </xsl:template><xsl:template match="BOTON" mode="init">
      
      <xsl:if test="$vgQuieroDruidaBack='S'">
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template><xsl:template match="BOTON" mode="body">

      <xsl:choose>
         <xsl:when test="@tipo != 'html'">
            <xsl:call-template name="BOTONbody_druida"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONbody_nativo"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template><xsl:template name="BOTONbody_nativo">
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
   </xsl:template><xsl:template name="BOTONbody_druida">
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
   </xsl:template><xsl:template name="BOTON">
      <A HREF="javascript:void(null);">
         <xsl:variable name="vTooltip3">
            <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
               <xsl:call-template name="langtxt.i10n">
                  <xsl:with-param name="pCod" select="@tooltip"/>
               </xsl:call-template>
            </xsl:if>
         </xsl:variable> 
         <xsl:variable name="vTxt">
            <xsl:call-template name="texto.boton"/>
         </xsl:variable>
         <xsl:if test="string-length($vTooltip3)&gt;0 and $vgTooltip and $vgTooltip='NATIVO'">
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
            <xsl:when test="@tipo='0'">
               <xsl:call-template name="IMAGEN-BOTON">
                  <xsl:with-param name="img0" select="0"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="@estado='true'">
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
   </xsl:template><xsl:template name="IMAGEN-BOTON">
      <xsl:param name="img0"/>
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
   </xsl:template><xsl:template name="BOTONnativo">

      <xsl:variable name="vTooltip2">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 
      <xsl:variable name="vTxt">
         <xsl:call-template name="texto.boton"/>
      </xsl:variable>

      <input ID="{@ID}" type="button" name="{@nombre}" value="{$vTxt}">
         <xsl:if test="string-length($vTooltip2)&gt;0 and $vgTooltip and $vgTooltip='NATIVO'">
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
            <xsl:text>;return false;</xsl:text>
         </xsl:attribute>

         
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

   </xsl:template><xsl:template name="BOTONscript_druida">
      

      <xsl:variable name="vTxt">
         <xsl:call-template name="texto.boton"/>
      </xsl:variable>

      <xsl:variable name="vNombreI">
         <xsl:text>.document.images["</xsl:text> 
         <xsl:value-of select="@nombre"/>
         <xsl:text>I"]</xsl:text> 
      </xsl:variable>
      
      

      <xsl:variable name="vUnSoloClick">
         <xsl:choose>
            <xsl:when test="@unSoloClick and @unSoloClick='S'">true</xsl:when>
            <xsl:otherwise>false</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vTooltip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 

      
      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Boton('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
      <xsl:value-of select="concat($vgImgPath,@img)"/>
      <xsl:text>','</xsl:text>
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
            <xsl:choose>
               <xsl:when test="@escapaJs and @escapaJs='S'">
                  <xsl:call-template name="escapaCaracterYBarra">
                     <xsl:with-param name="text"><xsl:value-of select="@accion"/></xsl:with-param>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="@accion"/>
               </xsl:otherwise>
            </xsl:choose>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>null</xsl:text>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>,</xsl:text>
            <xsl:text>'</xsl:text>
            <xsl:value-of select="$vTxt"/>
            <xsl:text>'</xsl:text>
      <xsl:text>,</xsl:text>
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
      <xsl:text>,</xsl:text>
      <xsl:value-of select="$vUnSoloClick"/>
      <xsl:text>,</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length($vTooltip)&gt;0">
            <xsl:text>'</xsl:text><xsl:value-of select="$vTooltip"/><xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>null</xsl:text>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>);</xsl:text>

   
   <xsl:if test="@ontab and string-length(@ontab)&gt;0">
      <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if (shift_pul||codigoTecla!=9){return true;} </xsl:text>
      <xsl:value-of select="@ontab"/>
      <xsl:text>;event.returnValue=false;} </xsl:text>
   </xsl:if>

   
   <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
      <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if (!shift_pul||codigoTecla!=9){return true;} </xsl:text>
      <xsl:value-of select="@onshtab"/>
      <xsl:text>;event.returnValue=false;} </xsl:text>
   </xsl:if>

   </xsl:template><xsl:template name="BOTONscript_nativo">
      

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Boton('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
      <xsl:text>','</xsl:text>
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
      <xsl:text>,</xsl:text>

      <xsl:text>null</xsl:text>

      <xsl:text>,</xsl:text>
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

      <xsl:text>,</xsl:text>
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
      <xsl:text>);</xsl:text>

   
      
      <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if(shift_pul||codigoTecla!=9){return true;} </xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

      
      <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if (!shift_pul || codigoTecla!=9){return true;} </xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

   </xsl:template><xsl:template name="texto.boton">
      <xsl:choose>
         <xsl:when test="@cod and string-length(@cod) &gt; 0">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@cod"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@alt"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template><xsl:template match="BOTONERA" mode="head">


         <xsl:apply-templates mode="head"/>

   </xsl:template><xsl:template match="BOTONERA" mode="estilo">
<xsl:text>
</xsl:text>

      <xsl:text>
#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>{</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;visibility:inherit;}</xsl:text>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="BOTONERA" mode="init">
      
      <xsl:if test="$vgQuieroDruidaBack='S'">
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="BOTONERA" mode="script">
      
      <xsl:value-of select="@nombre"/>
      <xsl:text>=new drdBotonera('</xsl:text>
      
      <xsl:text>');</xsl:text>
     

      <xsl:apply-templates mode="script">

      </xsl:apply-templates>

   </xsl:template><xsl:template match="BOTONERA" mode="body">

      <xsl:choose>
         <xsl:when test="name(../.)='TD'">
            <xsl:call-template name="BOTONERA"/>
         </xsl:when>

         <xsl:when test="@x!='0' or @y!='0'">
            <DIV ID="{@nombre}">
               <xsl:call-template name="BOTONERA"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONERA"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template name="BOTONERA">
      <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0"><xsl:apply-templates mode="body"/></TABLE>
   </xsl:template><xsl:template match="BTN" mode="estilo">



   </xsl:template><xsl:template match="BTN" mode="script">

      <xsl:variable name="vNombre">
         <xsl:value-of select="../@nombre"/> 
         <xsl:number/>
      </xsl:variable>

      <xsl:variable name="vNumBtn">
         <xsl:number/>
      </xsl:variable>

      <xsl:variable name="vActivo">
         <xsl:choose>
           <xsl:when test="@estado='inactivo'">false</xsl:when>
           <xsl:otherwise>true</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>


      <xsl:if test="@on">
         <xsl:value-of select="$vNombre"/>
         <xsl:text>=new drdBtn(</xsl:text>
         <xsl:value-of select="../@nombre"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="$vNumBtn"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="$vActivo"/>
         <xsl:text>,'</xsl:text>
         <xsl:value-of select="@off"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@disable"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@on"/>
         
         <xsl:text>');</xsl:text>
      </xsl:if>

      <xsl:if test="(@ontab and not(@ontab='')) or (@onshtab and not(@onshtab=''))">
         <xsl:text>function fonkd_</xsl:text><xsl:value-of select="concat(../@nombre,position())"/><xsl:text>(){</xsl:text>
         <xsl:text>TECLAEVENTO=event.keyCode;</xsl:text>
         <xsl:if test="@ontab and not(@ontab='')">
            <xsl:text>if (TECLAEVENTO==9 &amp;&amp; !event.shiftKey){</xsl:text>
            <xsl:value-of select="@ontab"/>
            <xsl:text>;return false;}</xsl:text>
         </xsl:if>
         <xsl:if test="@onshtab and not(@onshtab='')">
            <xsl:text>if (TECLAEVENTO==9 &amp;&amp; event.shiftKey){</xsl:text>
            <xsl:value-of select="@onshtab"/>
            <xsl:text>;return false}</xsl:text>
         </xsl:if>
         <xsl:text> return true;} </xsl:text>
      </xsl:if>

      <xsl:if test="@on">

         
         <xsl:text>function foc_</xsl:text>
         <xsl:value-of select="$vNombre"/><xsl:text>(){if(</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]){</xsl:text>

         <xsl:if test="(@unSoloClick and @unSoloClick='S') or (../@unSoloClick and ../@unSoloClick='S')">
            <xsl:text>set_estado_botonera('</xsl:text>
            <xsl:value-of select="../@nombre"/>
            <xsl:text>',</xsl:text>
            <xsl:value-of select="$vNumBtn"/>
            <xsl:text>,'inactivo');</xsl:text>
         </xsl:if>

         <xsl:variable name="vTxtFunc">
            <xsl:if test="@funcion">
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="@funcion"/>
                   <xsl:with-param name="caracter">"</xsl:with-param>
               </xsl:call-template>
            </xsl:if>
         </xsl:variable>
         
         
         
         <xsl:value-of select="@funcion"/>

         <xsl:text>}} </xsl:text>

         <xsl:text>function fomo_</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>(){if(</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]){img_to('</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>','</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>.off');}}</xsl:text>
         <xsl:text>function fomov_</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>(){if(</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]){img_to('</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>','</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>.on');status='</xsl:text><xsl:value-of select="@texto"/><xsl:text>';return true;}}</xsl:text>
      </xsl:if>

      <xsl:apply-templates mode="script"/>

   </xsl:template><xsl:template match="BTN" mode="body">

      <xsl:variable name="vNombre">
         <xsl:value-of select="../@nombre"/> 
         <xsl:number/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@x!='' or @y!=''">
            <DIV>
               <xsl:call-template name="BTN">
                  <xsl:with-param name="nombre" select="$vNombre"/>
               </xsl:call-template>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
	         <xsl:choose>
		         <xsl:when test="../@tipo='V'">
                  <TR><TD><xsl:choose>
		                  <xsl:when test="@on">
		                     <xsl:call-template name="BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:when>
		                  <xsl:otherwise>
		                     <xsl:call-template name="IMG-BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:otherwise>
		               </xsl:choose></TD>
                  </TR></xsl:when>
		         <xsl:otherwise>
		            <TD>
		               <xsl:choose>
		                  <xsl:when test="@on">
		                     <xsl:call-template name="BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:when>
		                  <xsl:otherwise>
		                     <xsl:call-template name="IMG-BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:otherwise>
		               </xsl:choose>
		            </TD>
                     <xsl:if test="../@espaciado"><xsl:call-template name="ESPACIADO-BTNS"/></xsl:if> 
		         </xsl:otherwise>
		 </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template name="BTN">
      <xsl:param name="nombre"/>
      <A HREF="javascript:void(null);" ID="{../@nombre}_AHREF">
         <xsl:if test="(@ontab and not(@ontab='')) or (@onshtab and not(@onshtab=''))">
            <xsl:attribute name="onKeyDown">
               <xsl:text>return (fonkd_</xsl:text><xsl:value-of select="concat(../@nombre,position())"/><xsl:text>())</xsl:text>
            </xsl:attribute>
         </xsl:if>
         <xsl:attribute name="onClick">
            <xsl:text>foc_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>();return false;</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onMouseOut">
            <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>();</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onMouseOver">
            <xsl:text>fomov_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>();</xsl:text>
         </xsl:attribute>
         <xsl:call-template name="IMG-BTN">
            <xsl:with-param name="nombre" select="$nombre"/>
         </xsl:call-template>
      </A>
   </xsl:template><xsl:template name="IMG-BTN">
      <xsl:param name="nombre"/>

      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="@texto"/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>



      <IMG NAME="{$nombre}" src="{concat($vgImgPath,@off)}" BORDER="0" ALT="{$vTxt}">
         <xsl:attribute name="src">
            <xsl:choose>
               <xsl:when test="@disable!='' and @estado='inactivo'">
                  <xsl:value-of select="concat($vgImgPath,@disable)"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="concat($vgImgPath,@off)"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:attribute>
      </IMG>
   </xsl:template><xsl:template name="ESPACIADO-BTNS">
      <TD>
      <IMG style="visibility:hidden" BORDER="0" width="{../@espaciado}"/>
      </TD>
   </xsl:template><xsl:template match="ARBOL" mode="head">
      
      <SCRIPT>
         <xsl:text>DrdPrecImgsMRut(""</xsl:text>
         <xsl:if test="@imgFondo and @imgFondo!=''">,"<xsl:value-of select="@imgFondo"/>1.gif"</xsl:if>
         <xsl:if test="@icorama and @icorama!=''">,"<xsl:value-of select="@icorama"/>1.gif","<xsl:value-of select="@icorama"/>0.gif"</xsl:if>
         <xsl:if test="@icofinal and @icofinal!=''">,"<xsl:value-of select="@icofinal"/>.gif"</xsl:if>
         <xsl:for-each select="ICONOS/ICONO">
            <xsl:text>,"</xsl:text><xsl:value-of select="@src"/><xsl:text>"</xsl:text>
         </xsl:for-each>
         <xsl:text>)</xsl:text>
      </SCRIPT>
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3arbol.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="ARBOL" mode="estilo">
      <xsl:text>
</xsl:text>
      <xsl:if test="@pintadoSimplificado and @pintadoSimplificado='S'">
         <xsl:text>.brdTblDat</xsl:text><xsl:value-of select="@nombre"/><xsl:text> {width:100%}
</xsl:text>
         <xsl:text>.brdTblDat</xsl:text><xsl:value-of select="@nombre"/> tr {height:<xsl:value-of select="@altofila"/><xsl:text>px;}
</xsl:text>
         <xsl:text>.brdTblDat</xsl:text><xsl:value-of select="@nombre"/><xsl:text> td {vertical-align:middle}
</xsl:text>
         <xsl:text>.brdTblDat</xsl:text><xsl:value-of select="@nombre"/><xsl:text> a {width:100%;cursor:hand}
</xsl:text>
         <xsl:text>.brdTblDat</xsl:text><xsl:value-of select="@nombre"/><xsl:text> img {border:none}
</xsl:text>
      </xsl:if>
      <xsl:choose>
         <xsl:when test="@scroll and @scroll='N'">
            <xsl:text>#</xsl:text>
            <xsl:value-of select="@nombre"/>Scroll{position:absolute; overflow: hidden; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/>; layer-background-color: <xsl:value-of select="@colorf"/>; background-color: <xsl:value-of select="@colorf"/>
            <xsl:text>}
</xsl:text>
         </xsl:when> 
         <xsl:otherwise>
            <xsl:call-template name="SCROLLestilo">
               <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
               <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
               <xsl:with-param name="visibilidad">inherit</xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template><xsl:template match="ARBOL" mode="init">
      <xsl:choose>
         <xsl:when test="@multisel and @multisel='S'">
            <xsl:text>arbol('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','0');</xsl:text>
            <xsl:text>arbol('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','@');</xsl:text>
         </xsl:when> 
         <xsl:otherwise>
            <xsl:text>arbolM('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','0');</xsl:text>
            <xsl:text>arbolM('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','@');</xsl:text>
            <xsl:text>arbolM('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','O','0');</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template><xsl:template match="ARBOL" mode="script">


      <xsl:variable name="arbolscroll">
         <xsl:value-of select="concat(@nombre,'Scroll')"/>
      </xsl:variable>


      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>=new Object();
</xsl:text>

      <xsl:value-of select="@nombre"/><xsl:text>.imgs=new Array();
</xsl:text>

      <xsl:value-of select="@nombre"/><xsl:text>.vsb='</xsl:text><xsl:value-of select="@visibilidad"/><xsl:text>';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.bgcolor='</xsl:text><xsl:value-of select="@colorf"/><xsl:text>';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.oncolor='</xsl:text><xsl:value-of select="@oncolor"/><xsl:text>';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.overcolor='</xsl:text><xsl:value-of select="@overcolor"/><xsl:text>';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.idoff='</xsl:text><xsl:value-of select="@id"/><xsl:text>';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.id='</xsl:text><xsl:value-of select="@id"/><xsl:text>';
</xsl:text>
      <xsl:if test="@padreSeleccionable and @padreSeleccionable='S'">
         <xsl:value-of select="@nombre"/><xsl:text>.padreselecc=true;
</xsl:text>
      </xsl:if>
      <xsl:if test="@dobleClickAbre and @dobleClickAbre='S'">
         <xsl:value-of select="@nombre"/><xsl:text>.dblclick=true;
</xsl:text>
      </xsl:if>
      <xsl:if test="@msegDobleClick and not(@msegDobleClick='')">
         <xsl:value-of select="@nombre"/>.msegdblclick=<xsl:value-of select="@msegDobleClick"/><xsl:text>;
</xsl:text>
      </xsl:if>
      <xsl:value-of select="@nombre"/><xsl:text>.multiseleccion=</xsl:text>
      <xsl:choose>
        <xsl:when test="@multisel and @multisel='S'">true</xsl:when>
        <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>;
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.selecvisible=</xsl:text>
      <xsl:choose>
        <xsl:when test="@selecvisible and @selecvisible='S'">true</xsl:when>
        <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>;
</xsl:text>

      <xsl:if test="@repetirEnTooltip and @repetirEnTooltip='S'">
         <xsl:value-of select="@nombre"/><xsl:text>.repEnTooltip=true;
</xsl:text>
      </xsl:if>
      <xsl:if test="@numMaxCaracteres and @numMaxCaracteres!=''">
         <xsl:value-of select="@nombre"/>.maxCar=<xsl:value-of select="@numMaxCaracteres"/><xsl:text>;
</xsl:text>
      </xsl:if>
      <xsl:if test="@caractPorTab and @caractPorTab!=''">
         <xsl:value-of select="@nombre"/>.carPorTab=<xsl:value-of select="@caractPorTab"/><xsl:text>;
</xsl:text>
      </xsl:if>

      <xsl:if test="@pintadoSimplificado and @pintadoSimplificado='S'">
         <xsl:value-of select="@nombre"/><xsl:text>.renderOptimizado=true;
</xsl:text>
      </xsl:if>

      <xsl:value-of select="@nombre"/><xsl:text>.ultima='.';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.E=new Vector();
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.TC='Arbol';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.ancho=</xsl:text><xsl:value-of select="@ancho"/><xsl:text>;
</xsl:text>

      <xsl:if test="@altofila and string-length(@altofila)&gt;0">
         <xsl:value-of select="@nombre"/><xsl:text>.altofila=</xsl:text>
         <xsl:value-of select="@altofila"/>
         <xsl:text>;
</xsl:text>
      </xsl:if>

      <xsl:if test="@indentado and string-length(@indentado)&gt;0">
         <xsl:value-of select="@nombre"/><xsl:text>.indentado=</xsl:text>
         <xsl:value-of select="@indentado"/>
         <xsl:text>;
</xsl:text>
      </xsl:if>

      <xsl:if test="@scroll and @scroll='N'">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.sinScroll=true;
</xsl:text>
      </xsl:if>

      <xsl:choose>
         <xsl:when test="@imgFondo and string-length(@imgFondo)&gt;0">
            <xsl:value-of select="@nombre"/><xsl:text>.imgFondo='</xsl:text>
            <xsl:value-of select="@imgFondo"/>
            <xsl:text>';
</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@nombre"/><xsl:text>.imgFondo=null;
</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 

      <xsl:if test="@icorama and string-length(@icorama)&gt;0">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.icorama='</xsl:text>
         <xsl:value-of select="@icorama"/>
         <xsl:text>';
</xsl:text>
      </xsl:if>

      <xsl:if test="@icofinal and string-length(@icofinal)&gt;0">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.icofinal='</xsl:text>
         <xsl:value-of select="@icofinal"/>
         <xsl:text>';</xsl:text>
      </xsl:if>

      <xsl:if test="@rollOverFila and @rollOverFila='S'">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.SELECC_ANCHO=true;
</xsl:text>
      </xsl:if>

      <xsl:value-of select="@nombre"/><xsl:text>.imgs=[];
</xsl:text>

      <xsl:apply-templates mode="script"/>
      
      <xsl:value-of select="@nombre"/><xsl:text>.seleccion0=new Array();
</xsl:text>

      <xsl:if test="@conectorCargaDinamica">
         <xsl:if test="not(@conectorCargaDinamica='')">
            <xsl:value-of select="@nombre"/><xsl:text>.dinamico=true;
</xsl:text>
            <xsl:value-of select="@nombre"/><xsl:text>.conector='</xsl:text><xsl:value-of select="@conectorCargaDinamica"/><xsl:text>';
</xsl:text>
         </xsl:if>
      </xsl:if>

      


      <xsl:choose>
         <xsl:when test="@scroll and @scroll='N'">
            <xsl:call-template name="CAPAscript">

               <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
               <xsl:with-param name="visibilidad">visible</xsl:with-param>
            </xsl:call-template>
         </xsl:when> 
         <xsl:otherwise>
            <xsl:call-template name="SCROLLscript">

               <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose> 

   <xsl:if test="@onOpenClose">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.onOpenClose='</xsl:text>
      <xsl:call-template name="escapaCaracterYBarra">
         <xsl:with-param name="text"><xsl:value-of select="@onOpenClose"/></xsl:with-param>
         <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>';
</xsl:text>
   </xsl:if>

   </xsl:template><xsl:template match="ARBOL/ICONOS" mode="script">
      <xsl:value-of select="../@nombre"/><xsl:text>.imgs=[</xsl:text>
      <xsl:for-each select="ICONO">
         <xsl:text>DrdImgPath()+'</xsl:text><xsl:value-of select="@src"/><xsl:text>'</xsl:text>
         <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>];</xsl:text>
      <xsl:if test="ICONO/@alto or ICONO/@ancho">
         <xsl:text>
</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.anchos=[</xsl:text>
         <xsl:for-each select="ICONO">
            <xsl:text>[</xsl:text>
            <xsl:choose><xsl:when test="@ancho">'<xsl:value-of select="@ancho"/>'</xsl:when><xsl:otherwise>''</xsl:otherwise></xsl:choose>
            <xsl:text>,</xsl:text>
            <xsl:choose><xsl:when test="@alto">'<xsl:value-of select="@alto"/>'</xsl:when><xsl:otherwise>''</xsl:otherwise></xsl:choose>            
            <xsl:text>]</xsl:text>
            <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
         </xsl:for-each>
         <xsl:text>];</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="RAMA" mode="script">
      <xsl:text>
</xsl:text>
      <xsl:value-of select="../@nombre"/><xsl:text>.entradas=[</xsl:text>

      <xsl:call-template name="TRONCO">
         <xsl:with-param name="nivel" select="@nombre"/>
      </xsl:call-template>

      <xsl:text>];
</xsl:text>
   
   </xsl:template><xsl:template match="RAMA" mode="scriptarbol">
      <xsl:param name="nivel"/>
      <xsl:text>,</xsl:text>
      <xsl:call-template name="TRONCO">
         <xsl:with-param name="nivel" select="concat($nivel,'.',@nombre)"/>
      </xsl:call-template>
   </xsl:template><xsl:template match="HOJA" mode="scriptarbol">
      <xsl:param name="nivel"/>
      <xsl:text>,</xsl:text>
      <xsl:call-template name="TRONCO">
         <xsl:with-param name="nivel" select="concat($nivel,'.',@nombre)"/>
      </xsl:call-template>
   </xsl:template><xsl:template name="TRONCO">
      <xsl:param name="nivel"/>

      <xsl:variable name="vSituacion">
         <xsl:choose>
           <xsl:when test="name()='RAMA'">P</xsl:when>
           <xsl:otherwise>H</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>




      <xsl:text>['</xsl:text><xsl:value-of select="$nivel"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@icono"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@codigo"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@texto"/><xsl:text>','</xsl:text>
      <xsl:value-of select="$vSituacion"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@onclick"/><xsl:text>']</xsl:text>
      <xsl:apply-templates mode="scriptarbol">
         <xsl:with-param name="nivel" select="$nivel"/>
      </xsl:apply-templates>
      
   </xsl:template><xsl:template match="ARBOL" mode="body">


      
      <xsl:variable name="nuevonombre">
         <xsl:value-of select="@nombre"/>
         <xsl:text>Scroll</xsl:text>
      </xsl:variable>
      <xsl:choose>
         <xsl:when test="@scroll and @scroll='N'">
            <DIV ID="{@nombre}Scroll"/>
         </xsl:when> 
         <xsl:otherwise>
            <xsl:call-template name="SCROLLbody">
               
               <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="@incy"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose> 

   </xsl:template><xsl:template match="ICONOS|RAMA|HOJA" mode="body">
   </xsl:template><xsl:template match="MENU" mode="head">
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-head"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-head"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="MENU" mode="estilo">
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-estilo"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-estilo"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="MENU" mode="init">
      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-init"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-init"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="MENU" mode="script">


      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-script">

            </xsl:call-template>
            <xsl:if test="@estiloSelecc">
               <xsl:text>
window.CLASS_RESALT="</xsl:text>
               <xsl:value-of select="@estiloSelecc"/>
               <xsl:text>";
</xsl:text>
            </xsl:if>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-script"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="MENU" mode="body">

      <xsl:choose>
         <xsl:when test="@tipo='vertical'">
            <xsl:call-template name="MENU-desp-body">

            </xsl:call-template>

         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="MENU-a-body"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="SUBMENU" mode="script">
      <xsl:choose>
         <xsl:when test="ancestor::MENU/@tipo='vertical'">
            <xsl:call-template name="SUBMENU-desp-script"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="SUBMENU-a-script"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="ENTRADA" mode="script">

      <xsl:choose>
         <xsl:when test="ancestor::MENU/@tipo='vertical'">
            <xsl:call-template name="ENTRADA-desp-script"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="ENTRADA-a-script"/>
         </xsl:otherwise>
      </xsl:choose>

   </xsl:template><xsl:template name="MENU-a-head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3menu.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template name="MENU-desp-head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3menuvert.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template name="MENU-a-estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template name="MENU-desp-estilo">
      
      <xsl:variable name="vX">
         <xsl:choose>
           <xsl:when test="@x"><xsl:value-of select="@x"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vY">
         <xsl:choose>
           <xsl:when test="@y"><xsl:value-of select="@y"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vAlto">
         <xsl:choose>
           <xsl:when test="@alto and string-length(@alto)&gt;0"><xsl:value-of select="@alto"/></xsl:when>
           <xsl:otherwise>100%</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vAncho">
         <xsl:choose>
           <xsl:when test="@ancho and string-length(@ancho)&gt;0"><xsl:value-of select="@ancho"/></xsl:when>
           <xsl:otherwise>100%</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vColorf">
         <xsl:choose>
           <xsl:when test="@colorf"><xsl:value-of select="@colorf"/></xsl:when>
           <xsl:otherwise>white</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$vX"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vY"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"><xsl:value-of select="@padding"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAncho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAlto"/></xsl:with-param>
         <xsl:with-param name="zindex"/>
         <xsl:with-param name="colorf"><xsl:value-of select="$vColorf"/></xsl:with-param>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
      </xsl:call-template>
   </xsl:template><xsl:template name="MENU-a-init">
      <xsl:text>posiciona();</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template name="MENU-desp-init">
      <xsl:text>iniciarArbol('Menu</xsl:text><xsl:value-of select="@nombre"/><xsl:text>');</xsl:text>
      <xsl:text>posicionarCapas(Menu</xsl:text><xsl:value-of select="@nombre"/><xsl:text>);</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template name="MENU-a-script">
      <xsl:text>
var temporizador0_menu = </xsl:text><xsl:value-of select="@retardo"/><xsl:text>;
</xsl:text>
      <xsl:apply-templates mode="script"/>
   </xsl:template><xsl:template name="MENU-desp-script">


      <xsl:call-template name="CAPAscript">

         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="contravsb"/>
      </xsl:call-template>

      
      <xsl:variable name="vOMenu"><xsl:text>Menu</xsl:text><xsl:value-of select="@nombre"/></xsl:variable> 
<xsl:text>
</xsl:text>
      <xsl:value-of select="$vOMenu"/><xsl:text>=new Object();</xsl:text>

      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nombre='</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>';</xsl:text>
     

      <xsl:variable name="vEspNiv1">
         <xsl:choose>
           <xsl:when test="@espacioNivel1"><xsl:value-of select="@espacioNivel1"/></xsl:when>
           <xsl:otherwise><xsl:value-of select="number(@altofila div 2)"/></xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:variable name="vEspNiv2">
         <xsl:choose>
           <xsl:when test="@espacioNivel2"><xsl:value-of select="@espacioNivel2"/></xsl:when>
           <xsl:otherwise>1</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.espacioNivel1=</xsl:text>
      <xsl:value-of select="$vEspNiv1"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.espacioNivel2=</xsl:text>
      <xsl:value-of select="$vEspNiv2"/>
      <xsl:text>;</xsl:text>

      <xsl:variable name="vMargenNiv1">
         <xsl:choose>
           <xsl:when test="@margennivel1"><xsl:value-of select="@margennivel1"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nivel1posY=</xsl:text>
      <xsl:value-of select="$vMargenNiv1"/>
      <xsl:text>;</xsl:text>

      <xsl:variable name="vMargenNiv2">
         <xsl:choose>
           <xsl:when test="@margennivel2"><xsl:value-of select="@margennivel2"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.nivel2posY=</xsl:text>
      <xsl:value-of select="$vMargenNiv2"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.altoFila=</xsl:text>
      <xsl:value-of select="@altofila"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgFondo='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imagenf"/>
      <xsl:text>';</xsl:text>

      <xsl:variable name="vPosH">
         <xsl:choose>
           <xsl:when test="@posh"><xsl:value-of select="@posh"/></xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.PosicionHorizontalDefecto=</xsl:text>
      <xsl:value-of select="$vPosH"/>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgfondoniv1='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imgfondoniv1"/>
      <xsl:text>';</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgfondoniv2='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imgfondoniv2"/>
      <xsl:text>';</xsl:text>
      <xsl:value-of select="$vOMenu"/>
      <xsl:text>.imgfondoniv3='</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imgfondoniv3"/>
      <xsl:text>';
</xsl:text>

      <xsl:value-of select="$vOMenu"/><xsl:text>.imgmenos=["</xsl:text><xsl:value-of select="concat($vgImgPath,@imgplegarN)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@imgplegarS)"/><xsl:text>"];
</xsl:text> 
      <xsl:value-of select="$vOMenu"/><xsl:text>.imgmas=["</xsl:text><xsl:value-of select="concat($vgImgPath,@imgdesplegarN)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@imgdesplegarS)"/><xsl:text>"];
</xsl:text> 
      <xsl:value-of select="$vOMenu"/><xsl:text>.iconiv1=["</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv1N)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv1S)"/><xsl:text>"];
</xsl:text> 
      <xsl:value-of select="$vOMenu"/><xsl:text>.iconiv2=["</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv2N)"/><xsl:text>","</xsl:text><xsl:value-of select="concat($vgImgPath,@iconiv2S)"/><xsl:text>"];
</xsl:text> 

      <xsl:variable name="vers">
         <xsl:if test="@version">
            <xsl:value-of select="@version"/>
         </xsl:if>
         <xsl:if test="not(@version)">1</xsl:if>
      </xsl:variable>

      <xsl:value-of select="$vOMenu"/><xsl:text>.niveles=</xsl:text><xsl:if test="$vers='2'">3;
</xsl:if><xsl:if test="not($vers='2')">2;
</xsl:if>

      <xsl:value-of select="$vOMenu"/><xsl:text>.opciones=[</xsl:text>
         <xsl:for-each select="SUBMENU">
            <xsl:variable name="vToolTip">
               <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
                  <xsl:call-template name="langtxt.i10n">
                     <xsl:with-param name="pCod" select="@tooltip"/>
                  </xsl:call-template>
               </xsl:if>
            </xsl:variable> 

            <xsl:text>["</xsl:text>

            <xsl:choose>
               <xsl:when test="count(*) &gt; 0">
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>", "</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>", "</xsl:text>
                  <xsl:value-of select="$vToolTip"/>
                  <xsl:text>", [</xsl:text>
                  <xsl:for-each select="*">
                     <xsl:call-template name="MNVERTOPCION"/>
                     <xsl:if test="position()!=last()">,</xsl:if>
                  </xsl:for-each> 
                  <xsl:text>]]</xsl:text>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>", "</xsl:text>
                  <xsl:value-of select="$vToolTip"/>
                  <xsl:text>",null]</xsl:text>
               </xsl:otherwise>
            </xsl:choose> 
                        
            

            
            <xsl:if test="position()!=last()">,</xsl:if>
         </xsl:for-each>
      <xsl:text>];
</xsl:text>

      <xsl:apply-templates mode="script"/>
   </xsl:template><xsl:template name="MENU-a-body">
      <SCRIPT>document.write(display());</SCRIPT>
   </xsl:template><xsl:template name="MENU-desp-body">
   
      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

      </DIV>
   </xsl:template><xsl:template name="SUBMENU-a-script">

      
      <xsl:variable name="mpadre">
         <xsl:choose>
            <xsl:when test="name(..)='MENU'">null</xsl:when>
            <xsl:otherwise>
               <xsl:text>'</xsl:text><xsl:value-of select="ancestor::SUBMENU[1]/@nombre"/><xsl:text>'</xsl:text>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      
      <xsl:variable name="epadre">
         <xsl:choose>
            <xsl:when test="name(..)='MENU'">null</xsl:when>
            <xsl:otherwise>
               <xsl:text>'</xsl:text><xsl:value-of select="generate-id(ancestor::ENTRADA[1])"/><xsl:text>'</xsl:text>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>
menu_add(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@tipo"/><xsl:text>',</xsl:text>
      <xsl:value-of select="$mpadre"/><xsl:text>,</xsl:text>
      <xsl:value-of select="$epadre"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@top"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@left"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@width"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@height"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@offset_x"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@offset_y"/><xsl:text>);</xsl:text>

      <xsl:apply-templates mode="script"/>

   </xsl:template><xsl:template name="SUBMENU-desp-script">
   </xsl:template><xsl:template name="ENTRADA-a-script">

      <xsl:choose>
         <xsl:when test="@on">
            <xsl:call-template name="ENTRADA_NORMAL"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="ENTRADA_IMG"/>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:apply-templates mode="script"/>

   </xsl:template><xsl:template name="ENTRADA-desp-script">
   </xsl:template><xsl:template name="ENTRADA_NORMAL">

      
      <xsl:variable name="mpadre">
         <xsl:value-of select="ancestor::SUBMENU[1]/@nombre"/>
      </xsl:variable>

      
      <xsl:variable name="mhijo">
         <xsl:choose>
            <xsl:when test="descendant::SUBMENU[1]/@nombre">
               <xsl:text>'</xsl:text><xsl:value-of select="descendant::SUBMENU[1]/@nombre"/><xsl:text>'</xsl:text>
            </xsl:when>
            <xsl:otherwise><xsl:text>null</xsl:text></xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      
      <xsl:variable name="nentrada">
         <xsl:value-of select="generate-id(.)"/>
      </xsl:variable>

      <xsl:variable name="link">
         <xsl:call-template name="escapa">
             <xsl:with-param name="text" select="@enlace"/>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
      </xsl:variable>

      <xsl:text>
entrada_add(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$mpadre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$nentrada"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="concat($vgImgPath,@off)"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="concat($vgImgPath,@on)"/><xsl:text>',</xsl:text>
      <xsl:value-of select="$mhijo"/><xsl:text>,</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$link"/><xsl:text>',</xsl:text> 
      <xsl:text>'</xsl:text><xsl:value-of select="@info"/><xsl:text>');</xsl:text>

   </xsl:template><xsl:template name="ENTRADA_IMG">

      
      <xsl:variable name="mpadre">
         <xsl:value-of select="ancestor::SUBMENU[1]/@nombre"/>
      </xsl:variable>

      <xsl:text>
imagen_add(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$mpadre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="concat($vgImgPath,@off)"/><xsl:text>');</xsl:text>

   </xsl:template><xsl:template name="MNVERTOPCION">
      <xsl:variable name="vToolTip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 

      <xsl:variable name="vTexto">
         <xsl:call-template name="SetTxtComponente.i10n"/>
      </xsl:variable> 




      <xsl:choose>
        <xsl:when test="name()='SUBMENU'">
            <xsl:text>["</xsl:text>
            <xsl:value-of select="$vTexto"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="@enlace"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="$vToolTip"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="1"/>
            <xsl:text>"],</xsl:text>

           <xsl:for-each select="ENTRADA|SUBMENU">
               <xsl:variable name="vToolTipES">
                  <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
                     <xsl:call-template name="langtxt.i10n">
                        <xsl:with-param name="pCod" select="@tooltip"/>
                     </xsl:call-template>
                  </xsl:if>
               </xsl:variable> 

               <xsl:if test="name()='ENTRADA'">
                  <xsl:text>["</xsl:text>
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="$vToolTipES"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="2"/>
                  <xsl:text>"]</xsl:text>
                  <xsl:if test="position()!=last()">,</xsl:if>
               </xsl:if>
               <xsl:if test="name()='SUBMENU'">
                  <xsl:text>["</xsl:text>
                  <xsl:call-template name="SetTxtComponente.i10n"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="@enlace"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="$vToolTipES"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="2"/>
                  <xsl:text>"],</xsl:text>
                  <xsl:for-each select="ENTRADA">
                     <xsl:variable name="vToolTipE">
                        <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
                           <xsl:call-template name="langtxt.i10n">
                              <xsl:with-param name="pCod" select="@tooltip"/>
                           </xsl:call-template>
                        </xsl:if>
                     </xsl:variable> 

                     <xsl:text>["</xsl:text>
                     <xsl:call-template name="SetTxtComponente.i10n"/>
                     <xsl:text>","</xsl:text>
                     <xsl:value-of select="@enlace"/>
                     <xsl:text>","</xsl:text>
                     <xsl:value-of select="$vToolTipE"/>
                     <xsl:text>","</xsl:text>
                     <xsl:value-of select="3"/>
                     <xsl:text>"]</xsl:text>
                     <xsl:if test="position()!=last()">,</xsl:if>
                  </xsl:for-each>
               </xsl:if>
            </xsl:for-each> 
        </xsl:when>
        <xsl:otherwise>
            <xsl:text>["</xsl:text>
            <xsl:value-of select="$vTexto"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="@enlace"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="$vToolTip"/>
            <xsl:text>","</xsl:text>
            <xsl:value-of select="1"/>
            <xsl:text>"]</xsl:text>
        </xsl:otherwise>
      </xsl:choose> 
      

   </xsl:template><xsl:template name="CAPAhead">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template name="CAPAestilo">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="visibilidad"/>
      <xsl:param name="colborde"/>
      <xsl:param name="padding"/>
      <xsl:param name="ancho"/> 
      <xsl:param name="alto"/>
      <xsl:param name="zindex"/>
      <xsl:param name="colorf"/>
      <xsl:param name="imagen"/>
      <xsl:param name="repeat"/>
      <xsl:param name="overflow"/>


      <xsl:text>
</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="$x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="$y"/>
      <xsl:text>;visibility:</xsl:text>
      <xsl:value-of select="$visibilidad"/>
      <xsl:text>;</xsl:text>

      <xsl:if test="$colborde!=''">
         <xsl:text>border:solid </xsl:text>
         <xsl:value-of select="$colborde"/>
         <xsl:text> 1px;</xsl:text>
      </xsl:if>

      <xsl:if test="$padding!=''">
         <xsl:text>padding:</xsl:text>
         <xsl:value-of select="$padding"/>
         <xsl:text>px;</xsl:text>
      </xsl:if>

      <xsl:if test="$ancho!=''">
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="$ancho"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$alto!=''">
         <xsl:text>height:</xsl:text>
         <xsl:value-of select="$alto"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$zindex!=''">
         <xsl:text>z-index:</xsl:text>
         <xsl:value-of select="$zindex"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

        <xsl:if test="$overflow!=''">
         <xsl:text>overflow:</xsl:text>
         <xsl:value-of select="$overflow"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$colorf!=''">
         <xsl:text>background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
         <xsl:text>layer-background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$imagen!=''">
         <xsl:text>background-image:URL(</xsl:text>
         <xsl:value-of select="$vgImgPath"/>
         <xsl:value-of select="$imagen"/>
         <xsl:text>);</xsl:text>
         <xsl:text>layer-background-image:URL(</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>);</xsl:text>
         <xsl:text>background-repeat:</xsl:text>
         <xsl:value-of select="$repeat"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="string-length($ancho)!=0 or string-length($alto)!=0">
         <xsl:text>clip:rect(0,</xsl:text>
         <xsl:value-of select="$ancho"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="$alto"/>
         <xsl:text>,0);</xsl:text>
      </xsl:if>

      <xsl:text>}</xsl:text>

   </xsl:template><xsl:template name="CAPAscript">
      
      <xsl:param name="nombre"/>
      <xsl:param name="visibilidad"/>
      <xsl:param name="contravsb"/>

      
      <xsl:value-of select="$nombre"/>
      <xsl:text>=new drdCapa('</xsl:text>
      
      <xsl:choose>
        <xsl:when test="$visibilidad = 'hidden'">hidden</xsl:when>
        <xsl:otherwise>visible</xsl:otherwise>
      </xsl:choose>
      <xsl:text>',"</xsl:text>
      <xsl:value-of select="$contravsb"/>
      <xsl:text>");</xsl:text>
   </xsl:template><xsl:template name="CAPAbody">
      
      <xsl:param name="nombre"/>
      <xsl:param name="estilo"/>
      <xsl:param name="clase"/>

      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$nombre"/>
         </xsl:attribute>

         <xsl:if test="not($estilo='')">
            <xsl:attribute name="STYLE">
               <xsl:value-of select="$estilo"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="not($clase='')">
            <xsl:attribute name="CLASS">
               <xsl:value-of select="$clase"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:apply-templates mode="body">
            
         </xsl:apply-templates>
      </DIV>
   </xsl:template><xsl:template match="CAPA" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="CAPA" mode="dinamico">

      <xsl:text>
DrMainEstatico.visibilidad('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:choose>
        <xsl:when test="@visibilidad and @visibilidad='hidden'">O</xsl:when>
        <xsl:otherwise>V</xsl:otherwise>
      </xsl:choose>
      <xsl:text>');</xsl:text>

      <xsl:text>
DrMainEstatico.moveTo('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>');</xsl:text>

      <xsl:apply-templates mode="dinamico"/>
   </xsl:template><xsl:template match="CAPA" mode="init">
      <xsl:if test="$vgQuieroDruidaBack='S'">
      
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="CAPA" mode="estilo">

      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="colborde"><xsl:value-of select="@colborde"/></xsl:with-param>
         <xsl:with-param name="padding"><xsl:value-of select="@padding"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="zindex"><xsl:value-of select="@zindex"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="imagen"><xsl:value-of select="@imagenf"/></xsl:with-param>
         <xsl:with-param name="repeat"><xsl:value-of select="@repeat"/></xsl:with-param>
      </xsl:call-template>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="CAPA" mode="script">
      

      <xsl:call-template name="CAPAscript">
         
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="contravsb"><xsl:value-of select="@contravsb"/></xsl:with-param>
      </xsl:call-template>

      <xsl:apply-templates mode="script">
         
      </xsl:apply-templates>

   </xsl:template><xsl:template match="CAPA" mode="body">
      

      <xsl:call-template name="CAPAbody">
         
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="estilo"><xsl:if test="@estilo and not(@estilo='')"><xsl:value-of select="@estilo"/></xsl:if></xsl:with-param>
         <xsl:with-param name="clase"><xsl:if test="@clase and not(@clase='')"><xsl:value-of select="@clase"/></xsl:if></xsl:with-param>
      </xsl:call-template>

   </xsl:template><xsl:variable name="vScrollNativoIE">
      <xsl:if test="$vNavegador">
          <xsl:choose>
            <xsl:when test="$vgConfig/DATOSPROY/TIPOSCROLL = 'NATIVO'  and  $vNavegador='IE'">S</xsl:when>
            <xsl:otherwise>N</xsl:otherwise>
          </xsl:choose>
      </xsl:if>
      <xsl:if test="not($vNavegador)">N</xsl:if>
   </xsl:variable><xsl:template name="SCROLLhead">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template name="SCROLLestilo">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="colorf"/>
      <xsl:param name="visibilidad"/>
      <xsl:param name="colores"/>
      
      <xsl:choose>
		   <xsl:when test="$vScrollNativoIE = 'S'">
            <xsl:call-template name="SCROLLestilo_nativoIE">
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="colorf"><xsl:value-of select="$colorf"/></xsl:with-param>
               <xsl:with-param name="visibilidad"><xsl:value-of select="$visibilidad"/></xsl:with-param>
               <xsl:with-param name="colores"><xsl:value-of select="$colores"/></xsl:with-param>
            </xsl:call-template>
		   </xsl:when>
		   <xsl:otherwise>
            <xsl:call-template name="SCROLLestilo_druida">
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="colorf"><xsl:value-of select="$colorf"/></xsl:with-param>
               <xsl:with-param name="visibilidad"><xsl:value-of select="$visibilidad"/></xsl:with-param>
            </xsl:call-template>            
		   </xsl:otherwise>
		</xsl:choose>
   </xsl:template><xsl:template name="SCROLLestilo_nativoIE">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="colorf"/>
      <xsl:param name="visibilidad"/>
      <xsl:param name="colores"/>

      
      <xsl:text>
#</xsl:text><xsl:value-of select="$nombre"/><xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text><xsl:value-of select="$x"/>;top:<xsl:value-of select="$y"/><xsl:text>;</xsl:text>
      <xsl:text>width:</xsl:text><xsl:value-of select="$ancho+16"/>;height:<xsl:value-of select="$alto+16"/><xsl:text>;</xsl:text>
      <xsl:text>overflow: auto;background-color:</xsl:text><xsl:value-of select="$colorf"/><xsl:text>;</xsl:text>

      <xsl:text>visibility:</xsl:text><xsl:value-of select="$visibilidad"/><xsl:text>;</xsl:text>
      <xsl:if test="not($colores = '')">
         
         <xsl:variable name="vCol"><xsl:value-of select="concat(normalize-space ($colores),',')"/></xsl:variable>

         <xsl:variable name="vScrf"><xsl:value-of select="substring-before($vCol,',')"/></xsl:variable><xsl:variable name="vCol2"><xsl:value-of select="substring-after($vCol,',')"/></xsl:variable>
         <xsl:variable name="vScrs"><xsl:value-of select="substring-before($vCol2,',')"/></xsl:variable><xsl:variable name="vCol3"><xsl:value-of select="substring-after($vCol2,',')"/></xsl:variable>
         <xsl:variable name="vScrh"><xsl:value-of select="substring-before($vCol3,',')"/></xsl:variable><xsl:variable name="vCol4"><xsl:value-of select="substring-after($vCol3,',')"/></xsl:variable>
         <xsl:variable name="vScr3"><xsl:value-of select="substring-before($vCol4,',')"/></xsl:variable><xsl:variable name="vCol5"><xsl:value-of select="substring-after($vCol4,',')"/></xsl:variable>
         <xsl:variable name="vScrd"><xsl:value-of select="substring-before($vCol5,',')"/></xsl:variable><xsl:variable name="vCol6"><xsl:value-of select="substring-after($vCol5,',')"/></xsl:variable>
         <xsl:variable name="vScrt"><xsl:value-of select="substring-before($vCol6,',')"/></xsl:variable><xsl:variable name="vCol7"><xsl:value-of select="substring-after($vCol6,',')"/></xsl:variable>
         <xsl:variable name="vScra"><xsl:value-of select="substring-before($vCol7,',')"/></xsl:variable>

         <xsl:if test="not($vScrf='')">scrollbar-face-color:<xsl:value-of select="$vScrf"/>;</xsl:if>
         <xsl:if test="not($vScrs='')">scrollbar-shadow-color:<xsl:value-of select="$vScrs"/>;</xsl:if>
         <xsl:if test="not($vScrh='')">scrollbar-highlight-color:<xsl:value-of select="$vScrh"/>;</xsl:if>
         <xsl:if test="not($vScr3='')">scrollbar-3dlight-color:<xsl:value-of select="$vScr3"/>;</xsl:if>
         <xsl:if test="not($vScrd='')">scrollbar-darkshadow-color:<xsl:value-of select="$vScrd"/>;</xsl:if>
         <xsl:if test="not($vScrt='')">scrollbar-track-color:<xsl:value-of select="$vScrt"/>;</xsl:if>
         <xsl:if test="not($vScra='')">scrollbar-arrow-color:<xsl:value-of select="$vScra"/>;</xsl:if>

      </xsl:if>
      
      <xsl:text>}
</xsl:text>
   </xsl:template><xsl:template name="SCROLLestilo_druida">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="colorf"/>
      <xsl:param name="visibilidad"/>


      <xsl:variable name="vIncx">
         <xsl:choose>
           <xsl:when test="$incy!='0'">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vIncy">
         <xsl:choose>
           <xsl:when test="$incx!='0'">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>
</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
       <xsl:value-of select="$x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="$y"/>
      <xsl:text>;</xsl:text>

      <xsl:text>width:</xsl:text>
      <xsl:value-of select="number($ancho + $vIncx)"/>
      <xsl:text>;</xsl:text>

      <xsl:text>height:</xsl:text>
      <xsl:value-of select="number($alto + $vIncy)"/>
      <xsl:text>;visibility:</xsl:text>
      <xsl:value-of select="$visibilidad"/>
      <xsl:text>;}
</xsl:text>

      <xsl:if test="$incy!='0'">
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:0;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsa {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:16;width:16;height:</xsl:text><xsl:value-of select="number($alto - 32)"/><xsl:text>;background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollg.gif);layer-background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollg.gif); repeat:yes;clip:rect(0,16,</xsl:text><xsl:value-of select="number($alto - 32)"/><xsl:text>,0);}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:</xsl:text><xsl:value-of select="number($alto - 16)"/><xsl:text>;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:16;visibility:hidden;}
</xsl:text>
      </xsl:if>

      <xsl:if test="$incx!='0'">
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi {position:absolute;left:0</xsl:text><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsm {position:absolute;left:16</xsl:text><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;width:</xsl:text><xsl:value-of select="number($ancho - 32)"/><xsl:text>;height:16;background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollc.gif);layer-background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollc.gif); repeat:yes;clip:rect(0,</xsl:text><xsl:value-of select="number($ancho - 32)"/><xsl:text>,16,0);}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd {position:absolute;left:</xsl:text><xsl:value-of select="number($ancho - 16)"/><xsl:text>;top:</xsl:text><xsl:value-of select="number($alto)"/><xsl:text>;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh {position:absolute;left:16</xsl:text><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;visibility:hidden;}
</xsl:text>
      </xsl:if>

      <xsl:if test="$incy!='0' and $incx!='0'">
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divse {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;}
</xsl:text>
      </xsl:if>

      <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divtv {position:absolute;left:0;top:0;width:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;height:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;clip:rect(0,</xsl:text><xsl:value-of select="$ancho"/><xsl:text>,</xsl:text><xsl:value-of select="$alto"/><xsl:text>,0);overflow:hidden;</xsl:text>
      <xsl:if test="$colorf!=''">
         <xsl:text>background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
         <xsl:text>layer-background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:text>}
</xsl:text>

      <xsl:text>#</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:0;top:0;}
</xsl:text>

   </xsl:template><xsl:template name="SCROLLinit">
      <xsl:param name="nombre"/>
      <xsl:value-of select="$nombre"/><xsl:text>_init();</xsl:text>
   </xsl:template><xsl:template name="SCROLLscript">

      <xsl:param name="nombre"/>
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="visibilidad"/>
      
      <xsl:choose>
		   <xsl:when test="$vScrollNativoIE = 'S'">
            <xsl:call-template name="SCROLLscript_nativoIE">

               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="visibilidad"><xsl:value-of select="$visibilidad"/></xsl:with-param>
            </xsl:call-template>
		   </xsl:when>
		   <xsl:otherwise>
            <xsl:call-template name="SCROLLscript_druida">
               <xsl:with-param name="nsdoc"/> 
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
            </xsl:call-template>            
		   </xsl:otherwise>
		</xsl:choose>
   </xsl:template><xsl:template name="SCROLLscript_nativoIE">

      <xsl:param name="nombre"/>
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="visibilidad"/>


      <xsl:value-of select="$nombre"/><xsl:text>=new drdScroll('</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:choose>
        <xsl:when test="$visibilidad = 'hidden'">hidden</xsl:when>
        <xsl:otherwise>visible</xsl:otherwise>
      </xsl:choose>
      <xsl:text>');</xsl:text>

      <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>_init(){FLAG_SCR_NATIVO='S'}</xsl:text>

      

   </xsl:template><xsl:template name="SCROLLscript_druida">
       <xsl:param name="nsdoc"/> 
      <xsl:param name="nombre"/>
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>


      <xsl:text>
</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>=new Object();</xsl:text>

      <xsl:choose>
         <xsl:when test="$incx!='0'">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activox=0;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activox=-1;</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:choose>
         <xsl:when test="$alto&lt;=48">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.alto=10;</xsl:text>
         </xsl:when>
         <xsl:when test="$alto&lt;=69">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.alto=16;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$nombre"/>
            <xsl:text>.alto=37;</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:choose>
         <xsl:when test="$incy!='0'">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activoy=0;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activoy=-1;</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:value-of select="$nombre"/><xsl:text>.top=0;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.left=0;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.width=</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.height=</xsl:text><xsl:value-of select="$alto"/><xsl:text>;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>.xpos=</xsl:text><xsl:value-of select="$x"/><xsl:text>;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.ypos=</xsl:text><xsl:value-of select="$y"/><xsl:text>;
</xsl:text>


      <xsl:if test="$incy!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrollv=new Image();</xsl:text><xsl:value-of select="$nombre"/> <xsl:text>scrollv.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollv.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollg=new Image();</xsl:text><xsl:value-of select="$nombre"/> <xsl:text>scrollg.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollg.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolls=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls.on=new Image();</xsl:text><xsl:value-of select="$nombre"/>scrolls.on.src="<xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolls1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolls0.gif";
</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb.on=new Image();</xsl:text><xsl:value-of select="$nombre"/>scrollb.on.src="<xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollb1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollb0.gif";
</xsl:text>
      </xsl:if>

      <xsl:if test="$incx!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrollh=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollh.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollh.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollc=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollc.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollc.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolld=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.on=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.on.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolld1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolld0.gif";
</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.on=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.on.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolli1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolli0.gif";
</xsl:text>
      </xsl:if>


      <xsl:if test="$incy!='0' and $incx!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrolle=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolle.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolle.gif";
</xsl:text>
      </xsl:if>


      <xsl:value-of select="$nombre"/>
      <xsl:text>.nsdoc='</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>';</xsl:text>


      <xsl:if test="$incy!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrolls.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>ss.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls"]';</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>sb.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb"]';</xsl:text>
      </xsl:if>

      <xsl:if test="$incx!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrolld.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>sd.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld"]';</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>si.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli"]';
</xsl:text>
     </xsl:if>

      <xsl:value-of select="$nombre"/><xsl:text>Div=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Div.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - string-length($nombre) - 14)"/><xsl:text>';</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Div.vsb='visible';</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>.initOK=false;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Div.TC='Scroll';
</xsl:text>

      <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>_init() {
</xsl:text>

    <xsl:text>if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.initOK==false) {
	</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.initOK=true;
</xsl:text>

      <xsl:text>var offsety=(ns?eval(</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.nsdoc+'.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.pageY'):getRealTop(document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>']));if (offsety!=</xsl:text><xsl:value-of select="$y"/><xsl:text>){</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.ypos=offsety;}
</xsl:text>
      <xsl:text>var offsetx=(ns?eval(</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.nsdoc+'.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.pageX'):getRealLeft(document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>']));if (offsetx!=</xsl:text><xsl:value-of select="$x"/><xsl:text>){</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.xpos=offsetx;}
</xsl:text>

      <xsl:text>}
</xsl:text> 



      <xsl:if test="$incy!='0'">

	 <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sa.document.captureEvents(Event.MOUSEDOWN);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sa.document.onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>py;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsa"].onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>py;}
</xsl:text>

	 
	 <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sv.document.captureEvents(Event.MOUSEMOVE);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sv.document.onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ay;var h=</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.document.height;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv"].onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ay;var h=document.all.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.scrollHeight;}
</xsl:text>
         <xsl:text>if (h&gt;</xsl:text><xsl:value-of select="$alto"/><xsl:text>) {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsv.visibility="inherit";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv.style.visibility="inherit";}}
</xsl:text>
         <xsl:text>else {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsv.visibility="hide";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv.style.visibility="hidden";}}
</xsl:text>

      <xsl:text>if (h&gt;=</xsl:text><xsl:value-of select="$alto"/><xsl:text>) {
	if (ie) {if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto==37) {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto=16;}}
	var alto=(</xsl:text><xsl:value-of select="$alto"/><xsl:text>-32)*(</xsl:text><xsl:value-of select="$alto"/><xsl:text>)/h;
	if (alto&lt;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto) {alto=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto;}
	if (alto&gt;(</xsl:text><xsl:value-of select="$alto"/><xsl:text>-32)) alto=</xsl:text><xsl:value-of select="$alto"/><xsl:text>-32;
</xsl:text>

		 <xsl:choose>
		   <xsl:when test="$vgScrollResize='S'">
		   </xsl:when>
		   <xsl:otherwise>
				<xsl:value-of select="$nombre"/><xsl:text>.alto=37;alto=37;</xsl:text>
			 </xsl:otherwise>
		 </xsl:choose>

 <xsl:text>if (ie) {document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>AscensorImg'].style.pixelHeight=alto;document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>AscensorImg'].style.pixelWidth=16;}
}
</xsl:text>

      </xsl:if>

      <xsl:if test="$incx!='0'">

         <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sm.document.captureEvents(Event.MOUSEDOWN);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sm.document.onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>px;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsm"].onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>px;}
</xsl:text>


         <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sh.document.captureEvents(Event.MOUSEMOVE);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sh.document.onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ax;var w=</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.document.width;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh"].onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ax;var w=document.all.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.scrollWidth;}
</xsl:text>
         <xsl:text>if (w&gt;</xsl:text><xsl:value-of select="$ancho"/><xsl:text>) {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsh.visibility="inherit";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh.style.visibility="inherit";}}
</xsl:text>
         <xsl:text>else {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsh.visibility="hide";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh.style.visibility="hidden";}}
</xsl:text>
      </xsl:if>

      <xsl:text>}
</xsl:text>


      <xsl:if test="$incy!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>py(e) {paginadoy("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageY:event.y+document.body.scrollTop);return false;}
</xsl:text>
      </xsl:if>
      <xsl:if test="$incx!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>px(e) {paginadox("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageX:event.x+document.body.scrollLeft);return false;}
</xsl:text>
      </xsl:if>

      <xsl:if test="$incy!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>ay(e) {ascensory("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageY:event.y+document.body.scrollTop);return false;}
</xsl:text>
      </xsl:if>
      <xsl:if test="$incx!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>ax(e) {ascensorx("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageX:event.x+document.body.scrollLeft);return false;}
</xsl:text>
      </xsl:if>

      

      <xsl:if test="$incy!='0'">

      
         <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss() { </xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy=1;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolls','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls.on');scrolly('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>',+</xsl:text>
         <xsl:value-of select="$incy"/>
         <xsl:text>);}
</xsl:text>

      
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss() { </xsl:text>
         <xsl:text>img_to('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss() { </xsl:text>
         <xsl:text>img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolls','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','V');}}</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb() { </xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy=1;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb','</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb.on');scrolly('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>',-</xsl:text>
         <xsl:value-of select="$incy"/><xsl:text>);</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrollb','</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrollb.off'); if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      
         <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb() { </xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrollb.off'); if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      </xsl:if>

      <xsl:if test="$incx!='0'">

      
      <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi() { </xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activox=1;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli','</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli.on');scrollx('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>',+</xsl:text>
         <xsl:value-of select="$incx"/><xsl:text>);</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrolli','</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrolli.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activox==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi() { </xsl:text>
         <xsl:text>img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolli.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activox==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd() { </xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activox=1;img_to('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld','</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.on');scrollx('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>',-</xsl:text><xsl:value-of select="$incx"/><xsl:text>);</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld','</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off');if (ns) { if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox==1){visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      
      <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld','</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off');if (ns) { if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox==1){visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      </xsl:if>

   </xsl:template><xsl:template name="SCROLLbody">

      <xsl:param name="nombre"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="alto">0</xsl:param>
      <xsl:param name="estilo"/>
      
      <xsl:choose>
		   <xsl:when test="$vScrollNativoIE = 'S'">
            <xsl:call-template name="SCROLLbody_nativoIE">

               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="estilo"><xsl:value-of select="$estilo"/></xsl:with-param>
            </xsl:call-template>
		   </xsl:when>
		   <xsl:otherwise>
            <xsl:call-template name="SCROLLbody_druida">
               <xsl:with-param name="nsdoc"/>
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
            </xsl:call-template>            
		   </xsl:otherwise>
		</xsl:choose>
   </xsl:template><xsl:template name="SCROLLbody_nativoIE">

      <xsl:param name="nombre"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="alto">0</xsl:param>
      <xsl:param name="estilo"/>


      
      <DIV onscroll="onScrollNativoIE('{$nombre}')">
         <xsl:attribute name="ID">
            <xsl:value-of select="$nombre"/>
         </xsl:attribute>
         <xsl:if test="$estilo != ''">
            <xsl:attribute name="style"><xsl:value-of select="$estilo"/></xsl:attribute>
         </xsl:if>
         <xsl:apply-templates select="*[not (name()='PAGINADO') and not (name()='OCUPADO')]" mode="body">

         </xsl:apply-templates>
      </DIV>
      

   </xsl:template><xsl:template name="SCROLLbody_druida">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="alto">0</xsl:param>

      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat($nombre,'Div.document.')"/>
         <xsl:value-of select="concat($nombre,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>



      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$nombre"/><xsl:text>Div</xsl:text>
         </xsl:attribute>
         <xsl:text>
</xsl:text>

         <xsl:if test="$incy!='0'">
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divss</xsl:text>
               </xsl:attribute>
               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>
		  
                  <xsl:attribute name="onmouseout">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrolls</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolls0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>

               </xsl:element>

            </DIV>
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsa</xsl:text>
               </xsl:attribute>
               <xsl:text> </xsl:text>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsb</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>

		  <xsl:attribute name="onmouseout">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrollb</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollb0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>

               </xsl:element>
            </DIV>
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsv</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseDown">
                     <xsl:text>scrollIEname='</xsl:text><xsl:value-of select="$nombre"/><xsl:text>';</xsl:text>
                     <xsl:value-of select="$nombre"/><xsl:text>.activoy=2</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseUp">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;} else { scrollIEup() }</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseOut">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;}</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollv.gif</xsl:text>
                     </xsl:attribute>

			   <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>AscensorImg</xsl:text>
               </xsl:attribute>



                     <xsl:attribute name="HEIGHT">
                        <xsl:text>&amp;{</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto};</xsl:text>
                     </xsl:attribute>

                     <xsl:attribute name="WIDTH">
                        <xsl:text>16</xsl:text>
                     </xsl:attribute>

                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>
         </xsl:if>

         <xsl:if test="$incx!='0'">
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsi</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>

                  <xsl:attribute name="onMouseOut">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrolli</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolli0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsm</xsl:text>
               </xsl:attribute>
               <xsl:text> </xsl:text>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsd</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>

                  <xsl:attribute name="onMouseOut">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrolld</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolld0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsh</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

                  <xsl:attribute name="onMouseDown">
                     <xsl:text>scrollIEname='</xsl:text><xsl:value-of select="$nombre"/><xsl:text>';</xsl:text>
                     <xsl:value-of select="$nombre"/><xsl:text>.activox=2</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseUp">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;} else { scrollIEup() }</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseOut">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;}</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollh.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>
         </xsl:if>

         <xsl:if test="$incy!='0' and $incx!='0'">
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divse</xsl:text>
               </xsl:attribute>

               <xsl:element name="IMG">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolle.gif</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="BORDER">
                     <xsl:text>0</xsl:text>
                  </xsl:attribute>
               </xsl:element>
            </DIV>
         </xsl:if>

         <DIV>
            <xsl:attribute name="ID">
               <xsl:value-of select="$nombre"/><xsl:text>Divtv</xsl:text>
            </xsl:attribute>

            <xsl:attribute name="onscroll">
			<xsl:text>if(</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy!=-1){</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=1;scrolly('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>',0);</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;}</xsl:text>

            </xsl:attribute>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/>
               </xsl:attribute>

               
               <xsl:apply-templates select="*[not (name()='PAGINADO') and not (name()='OCUPADO')]" mode="body">
                  <xsl:with-param name="nsdoc">
                     <xsl:value-of select="concat($nsdoc-local,'.document.',$nombre)"/>
                  </xsl:with-param>
               </xsl:apply-templates>

            </DIV>

         </DIV>

      </DIV>
   </xsl:template><xsl:template match="SCROLL" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="SCROLL" mode="estilo">

      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="colores"><xsl:value-of select="@colores"/></xsl:with-param>
      </xsl:call-template>

      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="SCROLL" mode="init">
      <xsl:value-of select="@nombre"/><xsl:text>_init();</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="SCROLL" mode="script">
    
      <xsl:call-template name="SCROLLscript">

         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
      </xsl:call-template>

      <xsl:apply-templates mode="script">


      </xsl:apply-templates>

   </xsl:template><xsl:template match="SCROLL" mode="body">


         <xsl:call-template name="SCROLLbody">

            <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         </xsl:call-template>


   </xsl:template><xsl:template match="SOLAPAS" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:if test="SOLAPA[@inicial='S'] and SOLAPA[@inicial='S']/CAPA">
            <xsl:text>DrMainEstatico.solapas_to('</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>','</xsl:text>
            <xsl:value-of select="SOLAPA[@inicial='S']/CAPA/@nombre"/>
            <xsl:text>',true);DrMainEstatico.visibilidad('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','V');</xsl:text>
         </xsl:if>
      </xsl:if>
      <xsl:apply-templates mode="dinamico" select="SOLAPA/CAPA/*"/>
   </xsl:template><xsl:template match="SOLAPAS" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="SOLAPAS" mode="estilo">
     
      <xsl:text>
</xsl:text>
      
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;visibility:hidden;}</xsl:text>

      <xsl:apply-templates mode="estilo">

      </xsl:apply-templates>
   </xsl:template><xsl:template match="SOLAPAS" mode="script">
      
<xsl:text>
</xsl:text>

      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>=new drdSolapas('</xsl:text>
      <xsl:value-of select="@nombre"/>
     
      <xsl:text>','</xsl:text>
      <xsl:value-of select="SOLAPA[@inicial='S']/CAPA/@nombre"/>
      <xsl:text>',[</xsl:text>
      <xsl:for-each select="SOLAPA">
         <xsl:call-template name="DELIMITA">
            <xsl:with-param name="cadena" select="CAPA/@nombre"/>
            <xsl:with-param name="sep">'</xsl:with-param>
         </xsl:call-template>
         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>],</xsl:text>

      <xsl:choose>
         <xsl:when test="@accion">
            <xsl:text>"</xsl:text><xsl:value-of select="@accion"/><xsl:text>"</xsl:text>
         </xsl:when>
         <xsl:otherwise>null</xsl:otherwise>
      </xsl:choose>

      <xsl:text>);</xsl:text>

      <xsl:apply-templates mode="script">

      </xsl:apply-templates>


   </xsl:template><xsl:template match="SOLAPAS" mode="init">
      <xsl:text>solapas_to('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="SOLAPA[@inicial='S']/CAPA/@nombre"/><xsl:text>',true);visibilidad('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','V');</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="SOLAPAS" mode="body">
    
      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

         <xsl:if test="@ancho">
            <xsl:attribute name="STYLE">
               <xsl:text>width=</xsl:text>
               <xsl:value-of select="@ancho"/>
               <xsl:text>;</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0">
            <TR>
               <xsl:for-each select="SOLAPA">
                  <xsl:variable name="vImagen">
                     <xsl:value-of select="../@nombre"/> 
                     <xsl:value-of select="position() - 1"/>
                  </xsl:variable>
                  <TD>

                  <xsl:variable name="vOnClick">
                     <xsl:text>img_to('</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>','</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>.chk');</xsl:text>
                      <xsl:text>solapas_to('</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="CAPA/@nombre"/><xsl:text>');return false;</xsl:text>
                  </xsl:variable>

                  <xsl:element name="A">           
                        <xsl:attribute name="HREF">javascript:void(0);</xsl:attribute>

                        <xsl:attribute name="onClick">
                           <xsl:text>foc_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>(); return false;</xsl:text>
                        </xsl:attribute>

                        <xsl:attribute name="onMouseOver">
                           <xsl:text>fomo_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>();</xsl:text>
                        </xsl:attribute>
                        <IMG NAME="{$vImagen}" SRC="{$vgImgPath}{@off}" BORDER="0" ALT="{@texto}"/>
                  </xsl:element>          

                  </TD>

            </xsl:for-each>
            </TR>
         </TABLE>

         <xsl:apply-templates mode="body">

         </xsl:apply-templates>
      </DIV>


   </xsl:template><xsl:template match="SOLAPA" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="SOLAPA" mode="init">
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="SOLAPA" mode="estilo">
      
      <xsl:apply-templates mode="estilo">

      </xsl:apply-templates>
   </xsl:template><xsl:template match="SOLAPA" mode="script">


      <xsl:variable name="numero"><xsl:number/></xsl:variable>
      <xsl:variable name="vImagen">
         <xsl:value-of select="../@nombre"/> 
         <xsl:value-of select="$numero - 1"/>
      </xsl:variable>
      
      <xsl:text/>

                   

      
        <xsl:text>function foc_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>(){solapas_to('</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="CAPA/@nombre"/><xsl:text>');}</xsl:text>

      
        <xsl:text>function fomo_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>(){status='</xsl:text><xsl:value-of select="@texto"/><xsl:text>';return true;}</xsl:text>
   
   

         <xsl:value-of select="$vImagen"/>
         <xsl:text>=new drdSolapa("</xsl:text>
         <xsl:value-of select="@off"/>
         <xsl:text>","</xsl:text>
         <xsl:value-of select="@on"/>
         
         <xsl:text>",</xsl:text>
         <xsl:value-of select="../@nombre"/>
         <xsl:if test="@on2 and @off2">
            <xsl:text>,'</xsl:text>
            <xsl:value-of select="@off2"/>
            <xsl:text>','</xsl:text>
            <xsl:value-of select="@on2"/>
            <xsl:text>'</xsl:text>
         </xsl:if>
         <xsl:text>);</xsl:text>


      <xsl:apply-templates mode="script">

      </xsl:apply-templates>


   </xsl:template><xsl:template match="SOLAPA" mode="body">
      

      <xsl:apply-templates mode="body">
        
      </xsl:apply-templates>
   </xsl:template><xsl:template name="REJILLABLQinit">
      <xsl:call-template name="SCROLLinit">
         <xsl:with-param name="nombre"><xsl:value-of select="concat(@nombre,'scroll')"/></xsl:with-param>
      </xsl:call-template>
   </xsl:template><xsl:template name="REJILLABLQestilo">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="vNumColsBlq" select="@colsbloqueo + 1"/>

      
      <xsl:variable name="vColsYBlq" select="PRESENTACION[@nombre='CabeceraY']/COL[position() &lt; number($vNumColsBlq)]"/>

      
      <xsl:variable name="vAnchoCols" select="sum($vColsYBlq/@ancho)"/>

      <xsl:variable name="vAnchoSI" select="$vAnchoCols"/>
         

      
      <xsl:variable name="vNumFilasCab" select="count(PRESENTACION[@nombre='CabeceraX']/ROWSET/ROW)"/>
      <xsl:variable name="vAltoSI" select="PRESENTACION[@nombre='CabeceraX']/COL[1]/@alto * $vNumFilasCab"/>

      <xsl:text>
</xsl:text>


      
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>SI</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoSI"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoSI"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"/>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
      </xsl:call-template>
      

      
      <xsl:variable name="vAnchoSD" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoSD" select="$vAltoSI"/>

      <xsl:text>
</xsl:text>


      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>SD</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y">0</xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"/>
         <xsl:with-param name="alto"/>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"/>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
      </xsl:call-template>



      
      <xsl:variable name="vAnchoII" select="$vAnchoSI"/>
      <xsl:variable name="vAltoII" select="@alto - $vAltoSI"/>

      <xsl:text>
</xsl:text>



      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>II</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y">0</xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"/>
         <xsl:with-param name="alto"/>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"/>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>

      </xsl:call-template>

      
      <xsl:variable name="vAnchoID" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoID" select="$vAltoII"/>

      <xsl:text>
</xsl:text>


      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x + $vAnchoSI"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y + $vAltoSI"/></xsl:with-param>
         <xsl:with-param name="incx">10</xsl:with-param>
         <xsl:with-param name="incy">10</xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoID"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoID"/></xsl:with-param>
         <xsl:with-param name="colorf"/>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>

   </xsl:template><xsl:template name="REJILLABLQscript">
      <xsl:param name="nsdoc-local"/>

      
      <xsl:variable name="capadiv-SI">
         <xsl:value-of select="concat(@nombre,'SI')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local-SI">
         <xsl:value-of select="concat($capadiv-SI,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local-SI">
         <xsl:value-of select="concat($nsdoc-local,$capa-nsdoc-parte-local-SI)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local-SI"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv-SI"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>



      
      <xsl:variable name="capa0div-SD">
         <xsl:value-of select="concat(@nombre,'SD0')"/>
      </xsl:variable>
      <xsl:variable name="capa0-nsdoc-parte-local-SD">
         <xsl:value-of select="concat($capa0div-SD,'.document.')"/>
      </xsl:variable>

      <xsl:variable name="capadiv-SD">
         <xsl:value-of select="concat(@nombre,'SD')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local-SD">
         <xsl:value-of select="concat($capadiv-SD,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local-SD">
         <xsl:value-of select="concat($nsdoc-local,$capa0-nsdoc-parte-local-SD,$capa-nsdoc-parte-local-SD)"/>
      </xsl:variable>


      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local-SD"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv-SD"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>



      

      
      
      <xsl:variable name="capa0div-II">
         <xsl:value-of select="concat(@nombre,'II0')"/>
      </xsl:variable>
      <xsl:variable name="capa0-nsdoc-parte-local-II">
         <xsl:value-of select="concat($capa0div-II,'.document.')"/>
      </xsl:variable>

      <xsl:variable name="capadiv-II">
         <xsl:value-of select="concat(@nombre,'II')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local-II">

         <xsl:value-of select="concat($capa0div-II,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local-II">
         <xsl:value-of select="concat($nsdoc-local,$capa0-nsdoc-parte-local-II,$capa-nsdoc-parte-local-II)"/>
      </xsl:variable>

      <xsl:variable name="vNumColsBlq" select="@colsbloqueo + 1"/>

      
      <xsl:variable name="vColsYBlq" select="PRESENTACION[@nombre='CabeceraY']/COL[position() &lt; number($vNumColsBlq)]"/>

      
      <xsl:variable name="vAnchoCols" select="sum($vColsYBlq/@ancho)"/>

      <xsl:variable name="vAnchoSI" select="$vAnchoCols"/>
      
      <xsl:variable name="vNumFilasCab" select="count(PRESENTACION[@nombre='CabeceraX']/ROWSET/ROW)"/>
      <xsl:variable name="vAltoSI" select="PRESENTACION[@nombre='CabeceraX']/COL[1]/@alto * $vNumFilasCab"/>

      <xsl:variable name="vAnchoSD" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoSD" select="$vAltoSI"/>

      <xsl:variable name="vAnchoII" select="$vAnchoSI"/>
      <xsl:variable name="vAltoII" select="@alto - $vAltoSI"/>
      <xsl:variable name="vAnchoID" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoID" select="$vAltoII"/>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local-II"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv-II"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>


      
      <xsl:variable name="vAnchoID-Scroll" select="$vAnchoSD"/>
      <xsl:variable name="vAltoID-Scroll" select="$vAltoII"/>
      <xsl:variable name="vCabHeight">0</xsl:variable>
      <xsl:variable name="pixelsborde">2</xsl:variable>
      <xsl:variable name="vIncX">10</xsl:variable>
      <xsl:variable name="vIncY">10</xsl:variable>

      <xsl:variable name="regillascroll">
         <xsl:value-of select="concat(@nombre,'scroll')"/>
      </xsl:variable>

      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($regillascroll,'Div.document.')"/>
         <xsl:value-of select="concat($regillascroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($capa-nsdoc-local-II,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>


      
      <xsl:call-template name="SCROLLscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$pixelsborde"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vCabHeight + 2 * $pixelsborde"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoID-Scroll - 16 - 2 * $pixelsborde"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoID-Scroll - $vCabHeight - 3 * $pixelsborde"/></xsl:with-param>
      </xsl:call-template>


      <xsl:value-of select="@nombre"/><xsl:text>scroll.asociay='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>II';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>scroll.yoffset=0;
</xsl:text>


      <xsl:variable name="vScrollH">
         <xsl:choose>
           <xsl:when test="PRESENTACION[@nombre='CabeceraX']/@desplazar='N'">N</xsl:when>
           <xsl:otherwise>S</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:if test="$vScrollH = 'S'">
         <xsl:value-of select="@nombre"/><xsl:text>scroll.asociax='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>SD';
   </xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>scroll.xoffset=0;
   </xsl:text>
      </xsl:if> 
      



   </xsl:template><xsl:template name="REJILLABLQbody">
      <xsl:param name="nsdoc-local"/>

      <DIV ID="{@nombre}SI">
         <xsl:for-each select="PRESENTACION[@nombre='CabeceraY']">
            <xsl:call-template name="REJILLAPRESENTACION">
               <xsl:with-param name="pTipo">SI</xsl:with-param>
            </xsl:call-template>
         </xsl:for-each> 
      </DIV>

      <xsl:variable name="vNumColsBlq" select="@colsbloqueo + 1"/>

      
      <xsl:variable name="vColsYBlq" select="PRESENTACION[@nombre='CabeceraY']/COL[position() &lt; number($vNumColsBlq)]"/>

      
      <xsl:variable name="vAnchoCols" select="sum($vColsYBlq/@ancho)"/>

      <xsl:variable name="vAnchoSI" select="$vAnchoCols"/>

      
      <xsl:variable name="vNumFilasCab" select="count(PRESENTACION[@nombre='CabeceraX']/ROWSET/ROW)"/>
      <xsl:variable name="vAltoSI" select="PRESENTACION[@nombre='CabeceraX']/COL[1]/@alto * $vNumFilasCab"/>

      
      <xsl:variable name="vAnchoSD" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoSD" select="$vAltoSI"/>

      
      <xsl:variable name="vAnchoII" select="$vAnchoSI"/>
      <xsl:variable name="vAltoII" select="@alto - $vAltoSI"/>

      <DIV ID="{@nombre}SD0" style="position:absolute;top:{@y};left:{@x+$vAnchoSI};clip:rect(0,{$vAnchoSD},{$vAltoSD},0);">
         <DIV ID="{@nombre}SD">
            <xsl:for-each select="PRESENTACION[@nombre='CabeceraX']">
               <xsl:call-template name="REJILLAPRESENTACION">
                  <xsl:with-param name="pTipo">SD</xsl:with-param>
               </xsl:call-template>
            </xsl:for-each>
         </DIV>
      </DIV>

      <DIV ID="{@nombre}II0" style="position:absolute;top:{@y+$vAltoSI};left:{@x};clip:rect(0,{$vAnchoII},{$vAltoII},0)">
         <DIV ID="{@nombre}II">

            <xsl:for-each select="PRESENTACION[@nombre!='CabeceraX' and @nombre!='CabeceraY']">
               <xsl:call-template name="REJILLAPRESENTACION">
                  <xsl:with-param name="pTipo">II</xsl:with-param>
               </xsl:call-template>
            </xsl:for-each>

         </DIV>
      </DIV>

      <xsl:variable name="vIncX">10</xsl:variable>
      <xsl:variable name="vIncY">10</xsl:variable>

      <DIV ID="{@nombre}ID">
         
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>scroll</xsl:text>
         </xsl:variable>

         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param> 
            <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
         </xsl:call-template>
      </DIV>

   </xsl:template><xsl:template name="REJILLAPRESENTACION">
      <xsl:param name="pTipo"/>

         <TABLE border="0" cellpadding="0" cellspacing="0" bgcolor="{../@colorf}">	
            <xsl:if test="@ID">
               <xsl:attribute name="id"><xsl:value-of select="@ID"/></xsl:attribute>
            </xsl:if> 
            <xsl:if test="@espaciado">
               <xsl:attribute name="cellspacing"><xsl:value-of select="@espaciado"/></xsl:attribute>
            </xsl:if> 

            <xsl:variable name="vNumFilas" select="count(ROWSET/ROW)"/>

            <xsl:for-each select="ROWSET/ROW">
               <TR>            	
                  
                  <xsl:variable name="vFilaActual" select="position()"/>

                  <xsl:variable name="vUltima">
                     <xsl:choose>
                       <xsl:when test="position()=last()">S</xsl:when>
                       <xsl:otherwise>N</xsl:otherwise>
                     </xsl:choose> 
                  </xsl:variable>

                  <xsl:variable name="vPrimera">
                     <xsl:choose>
                       <xsl:when test="position()=1">S</xsl:when>
                       <xsl:otherwise>N</xsl:otherwise>
                     </xsl:choose> 
                  </xsl:variable>

                  





                     <xsl:variable name="vCampoActual" select="position()"/>

                     <xsl:choose>
                        <xsl:when test="$pTipo='II'"> 
                           
                           <xsl:for-each select="CAMPO[position() &lt;= ancestor::REJILLA/@colsbloqueo and not (preceding-sibling::CAMPO/@colext &gt; 0)]">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each>
                        </xsl:when>
                        <xsl:when test="$pTipo='ID'">
                           <xsl:for-each select="CAMPO[position() &gt; ancestor::REJILLA/@colsbloqueo]">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each> 
                        </xsl:when>
                        <xsl:when test="$pTipo='SD'">
                           <xsl:for-each select="CAMPO">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each> 
                        </xsl:when>
                        <xsl:when test="$pTipo='SI'">
                           <xsl:for-each select="CAMPO">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each> 
                        </xsl:when>
                        <xsl:otherwise>
                        </xsl:otherwise>
                     </xsl:choose> 




                  
                  <TD><IMG style="visibility:hidden" width="0" height="{ancestor::PRESENTACION/COL[1]/@alto}"/>
                  </TD>
               </TR>            	
            </xsl:for-each> 
            

            <xsl:if test="TOTALES">
               <TR>
                  <xsl:for-each select="TOTALES/CAMPO">
                     <TD ID="{../@ID}" COLSPAN="{@colext}">
                        <xsl:choose>
                           <xsl:when test="@NOMBRE">
                              <xsl:variable name="vNombreCampo" select="@NOMBRE"/>
                              <xsl:value-of select="sum(ancestor::PRESENTACION/ROWSET/ROW/CAMPO[@NOMBRE=$vNombreCampo])"/>
                           </xsl:when>
                           <xsl:otherwise>
                              <xsl:value-of select="."/>
                           </xsl:otherwise>
                        </xsl:choose> 
                     </TD>
                  </xsl:for-each>
               </TR>
            </xsl:if> 

         </TABLE>	

      
   
   </xsl:template><xsl:template name="SUMAS">
      <xsl:param name="pNodos"/>
      <xsl:param name="pCampo"/>
      <xsl:param name="pValor"/>

         
      <xsl:variable name="vPresentacion">   
         <xsl:choose>
            <xsl:when test="contains($pNodos,',')">
               <xsl:value-of select="normalize-space(substring-before($pNodos,','))"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="normalize-space($pNodos)"/>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>   

         
      <xsl:variable name="vSumaLocal" select="sum(//PRESENTACION[@nombre=$vPresentacion]/ROWSET/ROW/CAMPO[@NOMBRE=$pCampo])"/>
      <xsl:variable name="vSumaParcial" select="$pValor + $vSumaLocal"/>

      <xsl:variable name="vNodosRestantes">
         <xsl:value-of select="normalize-space(substring-after($pNodos,','))"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="string-length($vNodosRestantes)&gt;0">
            <xsl:call-template name="SUMAS">
               <xsl:with-param name="pNodos" select="$vNodosRestantes"/>
               <xsl:with-param name="pCampo" select="$pCampo"/>
               <xsl:with-param name="pValor" select="$vSumaParcial"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vSumaParcial"/>
         </xsl:otherwise>
      </xsl:choose> 


   </xsl:template><xsl:template name="TDFILAEXTENDER">
      <xsl:param name="pCampoActual"/>
      <xsl:param name="pEstilo"/>
      <xsl:param name="pFilaActual"/>
      <xsl:param name="pNumFilas"/>

      <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>
      <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($pCampoActual)]"/>

      
      <xsl:variable name="vRowSpan" select="count(ancestor::ROWSET/ROW/CAMPO[number($pCampoActual)][.=$vContenido])"/> 

      <TD ID="{$pEstilo}" height="{$vCol/@alto}">
         <xsl:if test="@colext">
            <xsl:attribute name="COLSPAN">
               <xsl:value-of select="@colext"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="$vCol/@agrupar='S' and $vRowSpan &gt; 1">
            <xsl:attribute name="rowspan">
               <xsl:value-of select="$vRowSpan"/> 
            </xsl:attribute>
         </xsl:if> 
          
         <xsl:if test="$pFilaActual = $pNumFilas or $pFilaActual + $vRowSpan - 1 = $pNumFilas">
            <IMG style="visibility:hidden" height="1">
               <xsl:if test="$vCol/@ancho">
                  <xsl:attribute name="width">
                     <xsl:value-of select="$vCol/@ancho"/>
                  </xsl:attribute> 
               </xsl:if> 
            </IMG><br/>
         </xsl:if> 
         <xsl:value-of select="$vContenido"/>
      </TD>
   </xsl:template><xsl:template name="TDNORMAL">
      <xsl:param name="pCampoActual"/>
      <xsl:param name="pEstilo"/>
      <xsl:param name="pFilaActual"/>
      <xsl:param name="pNumFilas"/>

      <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>
      <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($pCampoActual)]"/>
      
      <TD ID="{$pEstilo}" height="{$vCol/@alto}">
         <xsl:if test="@colext">
            <xsl:attribute name="COLSPAN">
               <xsl:value-of select="@colext"/>
            </xsl:attribute>
         </xsl:if>

          
         <xsl:if test="$pFilaActual = $pNumFilas">
            <IMG style="visibility:hidden" height="1">
               <xsl:if test="$vCol/@ancho">
                  <xsl:attribute name="width">
                     <xsl:value-of select="$vCol/@ancho"/>
                  </xsl:attribute> 
               </xsl:if> 
            </IMG><br/>
         </xsl:if> 
         <xsl:value-of select="$vContenido"/>
      </TD>
   </xsl:template><xsl:template name="REJILLAPRESENTACIONCAMPO">
      <xsl:param name="pTipo"/>
      <xsl:param name="vCampoActual"/>
      <xsl:param name="vNumFilas"/>
      <xsl:param name="vFilaActual"/>
      <xsl:param name="vPrimera"/>
      <xsl:param name="vUltima"/>


      

      
      <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>

      <xsl:variable name="vCBloqueo" select="ancestor::REJILLA/@colsbloqueo"/>

      <xsl:variable name="vCampoReal">
         <xsl:choose>
           <xsl:when test="$pTipo='ID'">
               <xsl:value-of select="$vCampoActual + $vCBloqueo"/>
           </xsl:when>
           <xsl:otherwise>
               <xsl:value-of select="$vCampoActual"/>
           </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vEstiloPrimera" select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDPRIMERA"/>
      <xsl:variable name="vEstiloUltima" select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDULTIMA"/>
      <xsl:variable name="vEstiloN" select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@ID"/>
      <xsl:variable name="vEstiloPar" select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDPAR"/>
      <xsl:variable name="vEstiloImpar" select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDIMPAR"/>
      <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($vCampoReal)]"/>

      
      <xsl:variable name="vEstilo">
         <xsl:choose>
            <xsl:when test="$vUltima='S'">
               <xsl:choose>
                  <xsl:when test="$vCol/@IDULTIMA">
                     <xsl:value-of select="$vCol/@IDULTIMA"/>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="$vCol/@ID"/>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:when>
            <xsl:when test="$vPrimera='S'">
               <xsl:choose>
                  <xsl:when test="$vCol/@IDPRIMERA">
                     <xsl:value-of select="$vCol/@IDPRIMERA"/>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="$vCol/@ID"/>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:when>
            <xsl:otherwise>
      
               <xsl:choose>
                  <xsl:when test="$vFilaActual mod 2=0">
                     <xsl:choose>
                        <xsl:when test="string-length($vEstiloPar) &gt; 0">
                           <xsl:value-of select="$vEstiloPar"/>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:value-of select="$vEstiloN"/>
                        </xsl:otherwise>
                     </xsl:choose> 
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:choose>
                        <xsl:when test="string-length($vEstiloImpar) &gt; 0">
                           <xsl:value-of select="$vEstiloImpar"/>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:value-of select="$vEstiloN"/>
                        </xsl:otherwise>
                     </xsl:choose> 
                  </xsl:otherwise>
               </xsl:choose> 

            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vAgrupo">
         <xsl:choose>
           <xsl:when test="$vCol/@agrupar='S'">S</xsl:when>
           <xsl:otherwise>N</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:choose>
        <xsl:when test="@SUMA">
            <xsl:variable name="vNombreCampo" select="@SUMA"/>
            <xsl:variable name="vSumas">
               <xsl:call-template name="SUMAS">
                  <xsl:with-param name="pNodos" select="@PRESENTACION"/>
                  <xsl:with-param name="pCampo" select="@SUMA"/>
                  <xsl:with-param name="pValor">0</xsl:with-param>
               </xsl:call-template>
            </xsl:variable>
            <TD ID="{$vEstilo}" width="{../../../COL[number($vCampoReal)]/@ancho}" height="{../../../COL[$vCampoReal]/@alto}">
               <xsl:if test="$vFilaActual = $vNumFilas">
               <IMG style="visibility:hidden" height="1">
                  <xsl:if test="../../../COL[$vCampoReal]/@ancho">
                     <xsl:attribute name="width">
                        <xsl:value-of select="../../../COL[number($vCampoReal)]/@ancho"/>
                     </xsl:attribute> 
                  </xsl:if> 
                 </IMG><br/>
               </xsl:if> 
               <xsl:value-of select="$vSumas"/>
            </TD>
        </xsl:when>

        
        <xsl:otherwise>                     
         
            <xsl:choose>
               <xsl:when test="$vAgrupo='N'">
                  <xsl:call-template name="TDNORMAL">
                     <xsl:with-param name="pCampoActual" select="$vCampoReal"/>
                     <xsl:with-param name="pEstilo" select="$vEstilo"/>
                     <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                     <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                  </xsl:call-template>
               </xsl:when>

               <xsl:when test="$vAgrupo='S'">
                  <xsl:choose>
                    <xsl:when test="$vPrimera='S'">
                        <xsl:call-template name="TDFILAEXTENDER">
                           <xsl:with-param name="pCampoActual" select="$vCampoReal"/>
                           <xsl:with-param name="pEstilo" select="$vEstilo"/>
                           <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                           <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                        </xsl:call-template>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                           <xsl:when test="ancestor::ROWSET/ROW[number($vFilaActual - 1)]/CAMPO[number($vCampoReal)] != $vContenido">
                              <xsl:call-template name="TDFILAEXTENDER">
                                 <xsl:with-param name="pCampoActual" select="$vCampoReal"/>
                                 <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                 <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                              </xsl:call-template>
                           </xsl:when>
                           <xsl:otherwise>
                              
                           </xsl:otherwise>
                        </xsl:choose> 
                           
                    </xsl:otherwise>
                  </xsl:choose> 

               </xsl:when>
            </xsl:choose> 

         </xsl:otherwise>
      </xsl:choose>  

   </xsl:template><xsl:template name="Estilo_PAR-IMPAR">
      <xsl:param name="vFilaActual"/>
      <xsl:param name="vCol"/>

      <xsl:choose>
         <xsl:when test="$vFilaActual mod 2 = 0">
            <xsl:choose>
               <xsl:when test="$vCol/@IDPAR">
                  <xsl:value-of select="$vCol/@IDPAR"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$vCol/@ID"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:when>
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="$vCol/@IDIMPAR">
                  <xsl:value-of select="$vCol/@IDIMPAR"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$vCol/@ID"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template><xsl:template match="REJILLA" mode="head">
   </xsl:template><xsl:template match="REJILLA" mode="init">
      <xsl:if test="@colsbloqueo">
         <xsl:call-template name="REJILLABLQinit"/>

      </xsl:if> 
   </xsl:template><xsl:template match="REJILLA" mode="estilo">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">.</xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>


      <xsl:if test="@colsbloqueo">
         <xsl:call-template name="REJILLABLQestilo">
            <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         </xsl:call-template>
      </xsl:if> 
   </xsl:template><xsl:template match="REJILLA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">.</xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>


      <xsl:if test="@colsbloqueo">
         <xsl:call-template name="REJILLABLQscript">
            <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         </xsl:call-template>
      </xsl:if> 
   </xsl:template><xsl:template match="REJILLA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">.</xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@colsbloqueo">
            <xsl:call-template name="REJILLABLQbody">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:apply-templates mode="body"/>
         </xsl:otherwise>
      </xsl:choose> 
      
   </xsl:template><xsl:template match="REJILLA/PRESENTACION[@nombre != 'CabeceraX' and @nombre != 'CabeceraY']" mode="body">

         
         <xsl:variable name="vTablaTratar" select="position()"/>

         <xsl:choose>
            <xsl:when test="../@colsbloqueo&gt;0">
               <xsl:call-template name="REJILLAPRESENTACION">
                  <xsl:with-param name="pTipo">ID</xsl:with-param>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>

            <TABLE border="0" cellpadding="0" cellspacing="0" bgcolor="{../@colorf}">	
               <xsl:if test="@colorf and string-length(@colorf) &gt; 0">
                  <xsl:attribute name="bgcolor"><xsl:value-of select="@colorf"/></xsl:attribute>
               </xsl:if> 

               <xsl:if test="@ID">
                  <xsl:attribute name="id"><xsl:value-of select="@ID"/></xsl:attribute>
               </xsl:if> 
               <xsl:if test="@espaciado">
                  <xsl:attribute name="cellspacing"><xsl:value-of select="@espaciado"/></xsl:attribute>
               </xsl:if> 
               

               <xsl:variable name="vNumFilas" select="count(ROWSET/ROW)"/>

               <xsl:for-each select="ROWSET/ROW">
                  <TR>            	

                     
                     <xsl:variable name="vFilaActual" select="position()"/>

                     <xsl:variable name="vUltima">
                        <xsl:choose>
                          <xsl:when test="position()=last()">S</xsl:when>
                          <xsl:otherwise>N</xsl:otherwise>
                        </xsl:choose> 
                     </xsl:variable>

                     <xsl:variable name="vPrimera">
                        <xsl:choose>
                          <xsl:when test="position()=1">S</xsl:when>
                          <xsl:otherwise>N</xsl:otherwise>
                        </xsl:choose> 
                     </xsl:variable>

                     <xsl:for-each select="CAMPO">

                        <xsl:variable name="vCampoActual" select="position()"/>
                        <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>
                        <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($vCampoActual)]"/>

                        
                        <xsl:variable name="vEstilo">
                           <xsl:choose>
                              <xsl:when test="$vUltima='S'">
                                 <xsl:choose>
                                    <xsl:when test="$vCol/@IDULTIMA">
                                       <xsl:value-of select="$vCol/@IDULTIMA"/>
                                    </xsl:when>
                                    <xsl:otherwise>
                                       <xsl:call-template name="Estilo_PAR-IMPAR">
                                          <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                          <xsl:with-param name="vCol" select="$vCol"/>
                                       </xsl:call-template>
                                    </xsl:otherwise>
                                 </xsl:choose> 
                              </xsl:when>
                              <xsl:when test="$vPrimera='S'">
                                 <xsl:choose>
                                    <xsl:when test="$vCol/@IDPRIMERA">
                                       <xsl:value-of select="$vCol/@IDPRIMERA"/>
                                    </xsl:when>
                                    <xsl:otherwise>
                                       <xsl:call-template name="Estilo_PAR-IMPAR">
                                          <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                          <xsl:with-param name="vCol" select="$vCol"/>
                                       </xsl:call-template>
                                    </xsl:otherwise>
                                 </xsl:choose> 
                              </xsl:when>
                              <xsl:otherwise>

                                 <xsl:call-template name="Estilo_PAR-IMPAR">
                                    <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                    <xsl:with-param name="vCol" select="$vCol"/>
                                 </xsl:call-template>

                             </xsl:otherwise>
                           </xsl:choose> 
                        </xsl:variable> 

                        <xsl:variable name="vAgrupo">
                           <xsl:choose>
                             <xsl:when test="$vCol/@agrupar='S'">S</xsl:when>
                             <xsl:otherwise>N</xsl:otherwise>
                           </xsl:choose> 
                        </xsl:variable> 

                        <xsl:choose>
                          <xsl:when test="@SUMA">
                              <xsl:variable name="vNombreCampo" select="@SUMA"/>
                              <xsl:variable name="vSumas">
                                 <xsl:call-template name="SUMAS">
                                    <xsl:with-param name="pNodos" select="@PRESENTACION"/>
                                    <xsl:with-param name="pCampo" select="@SUMA"/>
                                    <xsl:with-param name="pValor">0</xsl:with-param>
                                 </xsl:call-template>
                              </xsl:variable>
                              <TD ID="{$vEstilo}" width="{$vCol/@ancho}" height="{$vCol/@alto}">
                                 <xsl:if test="$vFilaActual = $vNumFilas">
                                    <IMG style="visibility:hidden" height="1">
                                       <xsl:if test="$vCol/@ancho">
                                          <xsl:attribute name="width">
                                             <xsl:value-of select="$vCol/@ancho"/>
                                          </xsl:attribute> 
                                       </xsl:if> 
                                    </IMG><br/>
                                 </xsl:if> 
                                 <xsl:value-of select="$vSumas"/>
                              </TD>
                          </xsl:when>

                          
                          <xsl:otherwise>                     
                           
                              <xsl:choose>
                                <xsl:when test="$vAgrupo='N'">
   
                                   <xsl:call-template name="TDNORMAL">
                                    <xsl:with-param name="pCampoActual" select="$vCampoActual"/>
                                    <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                    <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                    <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                                   </xsl:call-template>
                                </xsl:when>

                                <xsl:when test="$vAgrupo='S'">
                                       <xsl:choose>
                                         <xsl:when test="$vPrimera='S'">
   
                                             <xsl:call-template name="TDFILAEXTENDER">
                                                <xsl:with-param name="pCampoActual" select="$vCampoActual"/>
                                                <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                                <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                                <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                                             </xsl:call-template>
                                         </xsl:when>
                                         <xsl:otherwise>
         
                                                <xsl:choose>
                                                  <xsl:when test="ancestor::ROWSET/ROW[$vFilaActual - 1]/CAMPO[$vCampoActual] != $vContenido">
   
                                                      <xsl:call-template name="TDFILAEXTENDER">
                                                         <xsl:with-param name="pCampoActual" select="$vCampoActual"/>
                                                         <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                                         <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                                         <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                                                     </xsl:call-template>
                                                  </xsl:when>
                                                  <xsl:otherwise>
                                                      
   
                                                  </xsl:otherwise>
                                                </xsl:choose> 
                                                
                                         </xsl:otherwise>
                                       </xsl:choose> 
                                       

                                </xsl:when>
                              </xsl:choose> 
                          </xsl:otherwise>
                        </xsl:choose>                      
                     </xsl:for-each> 
                  </TR>            	
               </xsl:for-each> 
               

               <xsl:if test="TOTALES">
                  <TR>
                     <xsl:for-each select="TOTALES/CAMPO">
                        <TD ID="{../@ID}" COLSPAN="{@colext}">
                           <xsl:choose>
                              <xsl:when test="@NOMBRE">
                                 <xsl:variable name="vNombreCampo" select="@NOMBRE"/>
                                 <xsl:value-of select="sum(ancestor::PRESENTACION/ROWSET/ROW/CAMPO[@NOMBRE=$vNombreCampo])"/>
                              </xsl:when>
                              <xsl:otherwise>
                                 <xsl:value-of select="."/>
                              </xsl:otherwise>
                           </xsl:choose> 
                        </TD>
                     </xsl:for-each>
                  </TR>
               </xsl:if> 

            </TABLE>	

         </xsl:otherwise>
      </xsl:choose> 
         




      
   
   </xsl:template><xsl:template name="LISTAestilo">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="vIncrex">
         <xsl:choose>
           <xsl:when test="@incy!='0'">
               <xsl:value-of select="number(@incx + 16)"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vIncrey">
         <xsl:choose>
            <xsl:when test="@incx!='0'">
               <xsl:value-of select="number(CABECERA/@height + @incy + 16)"/>
            </xsl:when>
           <xsl:otherwise><xsl:value-of select="CABECERA/@height"/></xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>
</xsl:text>

      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Div</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho + $vIncrex"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto + $vIncrey"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"/>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
      </xsl:call-template>

      <xsl:variable name="anchoCabecera">
         <xsl:choose>
           <xsl:when test="@ajustacab='S' and @incy != '0'">
               <xsl:value-of select="@ancho + 16"/>
           </xsl:when>
           <xsl:otherwise><xsl:value-of select="@ancho + 16"/></xsl:otherwise>
         </xsl:choose> 
         
      </xsl:variable>


      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>DivCab</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y">0</xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"><xsl:value-of select="$anchoCabecera"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
      </xsl:call-template>

      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>


   </xsl:template><xsl:template name="LISTAinit">
      <xsl:text>lista('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','0',[0]);lista('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','@');</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>Scroll_init();</xsl:text>
   </xsl:template><xsl:template name="LISTAscript">
      <xsl:param name="nsdoc-local"/>

      <xsl:text>
</xsl:text>

      <xsl:value-of select="CABECERA/@nombre"/><xsl:text>=new Object();</xsl:text><xsl:value-of select="CABECERA/@nombre"/><xsl:text>.TC='Tabla';
</xsl:text>

      <xsl:variable name="capadiv">
         <xsl:value-of select="concat(@nombre,'Div')"/>
      </xsl:variable>
      <xsl:variable name="capadivcab">
         <xsl:value-of select="concat(@nombre,'DivCab')"/>
      </xsl:variable>
      <xsl:variable name="listascroll">
         <xsl:value-of select="concat(@nombre,'Scroll')"/>
      </xsl:variable>


      <xsl:variable name="capa-nsdoc-parte-local">
         <xsl:value-of select="concat($capadiv,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local">

         <xsl:value-of select="concat($nsdoc-local,$capa-nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
      </xsl:call-template>



   
      <xsl:value-of select="@nombre"/><xsl:text>=new Object();
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.formulario='</xsl:text><xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.entraday=</xsl:text><xsl:value-of select="@entraday"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.entradax=</xsl:text><xsl:value-of select="@entradax"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.bgcolor='</xsl:text><xsl:value-of select="@colorf"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.oncolor='</xsl:text><xsl:value-of select="@oncolor"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.chkcolor='</xsl:text><xsl:value-of select="@chkcolor"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.multiple=</xsl:text>
      <xsl:choose>
         <xsl:when test="@multisel='S'">true</xsl:when> 
         <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.funcEstilosFilas='</xsl:text><xsl:value-of select="@funcionEstilosFilas"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.min=</xsl:text><xsl:value-of select="@nmin"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.max=</xsl:text><xsl:value-of select="@nmax"/><xsl:text>;
</xsl:text>


      <xsl:value-of select="@nombre"/><xsl:text>.caracteres=[</xsl:text>
      <xsl:for-each select="PRESENTACION/COL[@oculto='N' and @tipo!='indice']">
        <xsl:choose>
            <xsl:when test="@caracteres">
                <xsl:value-of select="@caracteres"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>0</xsl:text>
            </xsl:otherwise>
        </xsl:choose> 

         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];
</xsl:text>


   <xsl:choose>
      <xsl:when test="@accion!=''">
            <xsl:value-of select="@nombre"/>.accion="<xsl:value-of select="@accion"/><xsl:text>";</xsl:text>
      </xsl:when>
      <xsl:otherwise>
            <xsl:value-of select="@nombre"/><xsl:text>.accion=true;</xsl:text>
      </xsl:otherwise>
   </xsl:choose>


<xsl:text>
</xsl:text>
   
   <xsl:value-of select="@nombre"/><xsl:text>.col=new Array();</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.col[0]=[</xsl:text>

               
               <xsl:choose>
                 <xsl:when test="ancestor::PRESENTACION/@premarcado='S'">"'*'"</xsl:when>
                 <xsl:otherwise>""</xsl:otherwise>
               </xsl:choose>
            <xsl:text>,</xsl:text>

      <xsl:for-each select="PRESENTACION/COL[@oculto='N']">

         <xsl:choose>
            <xsl:when test="@tipo = 'indice'">
            </xsl:when>
            <xsl:when test="@tipo = 'campo'">
               <xsl:text>"get('</xsl:text><xsl:value-of select="@form"/><xsl:text>.</xsl:text><xsl:value-of select="@campo"/><xsl:text>')"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo = 'javascript'">
               <xsl:text>"</xsl:text><xsl:value-of select="@funcion"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];
</xsl:text>

   
   <xsl:value-of select="@nombre"/><xsl:text>.campos=new Array();</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.campos[0]=[0,</xsl:text>
      <xsl:for-each select="PRESENTACION/COL[@enviar='S']">

         <xsl:choose>
            <xsl:when test="@tipo = 'indice'"> 
               <xsl:text>""</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo = 'campo'">
               <xsl:text>"get('</xsl:text><xsl:value-of select="@form"/><xsl:text>.</xsl:text><xsl:value-of select="@campo"/><xsl:text>')"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo = 'javascript'">
               <xsl:text>"</xsl:text><xsl:value-of select="@funcion"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];
</xsl:text>


   <xsl:value-of select="@nombre"/><xsl:text>.nonulos=[0];
</xsl:text>


   <xsl:value-of select="@nombre"/><xsl:text>.entrada=new Array();
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.entrada[0]=</xsl:text>
      <xsl:text>'&lt;TABLE BORDER="0" CELLSPACING="1" CELLPADDING="0"&gt;&lt;TR&gt;&lt;TD&gt;</xsl:text>
      <xsl:text>&lt;TABLE BGCOLOR="" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="</xsl:text><xsl:value-of select="@ancho"/><xsl:text>"&gt;&lt;TR&gt;</xsl:text>

      
      <xsl:variable name="vHayIndice">
         <xsl:choose>
           <xsl:when test="count(PRESENTACION/COL[@tipo='indice']) &gt; 0">1</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:for-each select="PRESENTACION/COL[@oculto='N']">
         <xsl:text>&lt;TD ID="</xsl:text><xsl:value-of select="@id"/>
         <xsl:text>" WIDTH="</xsl:text><xsl:value-of select="@ancho"/><xsl:text>"&gt;</xsl:text>

         <xsl:choose>

            <xsl:when test="position()=1">


               <xsl:choose>
                  <xsl:when test="@tipo='indice'">
                     <xsl:text>&amp;nbsp;$i$&amp;nbsp;</xsl:text>
                  </xsl:when> 
                  <xsl:otherwise>
                     <xsl:text disable-output-escaping="no">&amp;nbsp;$</xsl:text>
                     <xsl:value-of select="position() - $vHayIndice"/>
                     <xsl:text disable-output-escaping="no">$&amp;nbsp;</xsl:text>
                  </xsl:otherwise>
               </xsl:choose>

               
            
            </xsl:when>

            <xsl:otherwise>
               <xsl:text disable-output-escaping="no">&amp;nbsp;$</xsl:text>
               <xsl:value-of select="position() - $vHayIndice"/>
               <xsl:text disable-output-escaping="no">$&amp;nbsp;</xsl:text>
            </xsl:otherwise>
         </xsl:choose>


         <xsl:text>&lt;/TD&gt;</xsl:text>
      </xsl:for-each>
      <xsl:text>&lt;/TR&gt;&lt;/TABLE&gt;</xsl:text>
      <xsl:text>&lt;/TD&gt;&lt;/TR&gt;&lt;/TABLE&gt;';
</xsl:text>


   

   

   <xsl:value-of select="@nombre"/><xsl:text>.col0=new Array();
</xsl:text>

   <xsl:for-each select="ROWSET/ROW">
      <xsl:variable name="FilActual"><xsl:value-of select="position()"/></xsl:variable>

      <xsl:value-of select="ancestor::LISTA/@nombre"/><xsl:text>.col0[</xsl:text>
      <xsl:value-of select="position() - 1"/>

      <xsl:text>]=[</xsl:text>


      <xsl:text>""</xsl:text>

      <xsl:for-each select="CAMPO">
         <xsl:variable name="vValorSinComilladoble">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="translate(concat(.,@VALOR), '&#xA;',' ')"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 
         <xsl:variable name="vValorEscapado">
            <xsl:call-template name="escapa2">
                <xsl:with-param name="text" select="$vValorSinComilladoble"/>
                <xsl:with-param name="caracter">'</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 
         
         <xsl:variable name="ColActual"><xsl:value-of select="position()"/></xsl:variable>

         <xsl:if test="../../../PRESENTACION/COL[position() - $vHayIndice = $ColActual and @oculto='N' and @tipo != 'indice']">
             <xsl:text>,"</xsl:text>
             <xsl:call-template name="DELIMITA">
               <xsl:with-param name="cadena" select="$vValorEscapado"/>
               <xsl:with-param name="sep">'</xsl:with-param>
             </xsl:call-template>
             <xsl:text>"</xsl:text>
         </xsl:if>

      </xsl:for-each>

      <xsl:text>];
</xsl:text>

   </xsl:for-each>





   
   <xsl:value-of select="@nombre"/><xsl:text>.campos0=new Array();
</xsl:text>

   <xsl:for-each select="ROWSET/ROW">
      <xsl:variable name="FilActual"><xsl:value-of select="position()"/></xsl:variable>

      <xsl:value-of select="ancestor::LISTA/@nombre"/><xsl:text>.campos0[</xsl:text>
      <xsl:value-of select="position() - 1"/>

      <xsl:text>]=[</xsl:text>

      <xsl:text>0</xsl:text>

      <xsl:for-each select="CAMPO">

         <xsl:variable name="vValorSinComilladoble">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="translate(concat(.,@VALOR), '&#xA;',' ')"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 
         <xsl:variable name="vValorEscapado">
            <xsl:call-template name="escapa2">
                <xsl:with-param name="text" select="$vValorSinComilladoble"/>
                <xsl:with-param name="caracter">'</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 

         <xsl:variable name="ColActual"><xsl:value-of select="position()"/></xsl:variable>

         <xsl:if test="../../../PRESENTACION/COL[position() - $vHayIndice = $ColActual and @enviar='S' and @tipo!='indice']">
             <xsl:text>,"</xsl:text>
             <xsl:call-template name="DELIMITA">
               <xsl:with-param name="cadena" select="$vValorEscapado"/>
               <xsl:with-param name="sep">'</xsl:with-param>
             </xsl:call-template>
             <xsl:text>"</xsl:text>
         </xsl:if>

      </xsl:for-each>

      <xsl:text>];
</xsl:text>

   </xsl:for-each>

   <xsl:value-of select="@nombre"/><xsl:text>.separador='</xsl:text><xsl:value-of select="@sep"/><xsl:text>';</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.ultima=0;</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.V=new Vector('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.V');</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.H=new Vector('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.H');</xsl:text>

   

   <xsl:variable name="nsdocSC-parte-local">
      <xsl:value-of select="concat($listascroll,'Div.document.')"/>
      <xsl:value-of select="concat($listascroll,'Divtv.document')"/>
   </xsl:variable>
   <xsl:variable name="nsdocSC-local">
      <xsl:value-of select="concat(concat($capa-nsdoc-local,'.'),$nsdocSC-parte-local)"/>
   </xsl:variable>


   <xsl:call-template name="SCROLLscript">
      <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
      <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
      <xsl:with-param name="x">0</xsl:with-param>
      <xsl:with-param name="y"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
      <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
      <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
      <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
      <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
   </xsl:call-template>


   <xsl:variable name="capacab-nsdoc-parte-local">
      <xsl:value-of select="concat('.',concat($capadivcab,'.document'))"/>
   </xsl:variable>
   <xsl:variable name="capacab-nsdoc-local">
      <xsl:value-of select="concat($capa-nsdoc-local,$capacab-nsdoc-parte-local)"/>
   </xsl:variable>

   <xsl:call-template name="CAPAscript">
      <xsl:with-param name="nsdoc"><xsl:value-of select="$capacab-nsdoc-local"/></xsl:with-param>
      <xsl:with-param name="nombre"><xsl:value-of select="$capadivcab"/></xsl:with-param>
      <xsl:with-param name="visibilidad">inherit</xsl:with-param>
   </xsl:call-template>


      
   <xsl:text>
</xsl:text>
   <xsl:for-each select="PRESENTACION/COL[@enviar='S']">
         <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text><xsl:value-of select="ancestor::LISTA/@nombre"/><xsl:text>H</xsl:text><xsl:value-of select="position()"/><xsl:text>TC='Hidden';
</xsl:text>
   </xsl:for-each>

   </xsl:template><xsl:template name="LISTAbody">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="capadiv">
         <xsl:value-of select="concat(@nombre,'Div')"/>
      </xsl:variable>
      <xsl:variable name="capadivcab">
         <xsl:value-of select="concat(@nombre,'DivCab')"/>
      </xsl:variable>


      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$capadiv"/>
         </xsl:attribute>

         <DIV>
            <xsl:attribute name="ID">
               <xsl:value-of select="$capadivcab"/>
            </xsl:attribute>

            <xsl:apply-templates select="CABECERA"/>


         </DIV> 

      
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>Scroll</xsl:text>
         </xsl:variable>

         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         </xsl:call-template>

      </DIV>  

   </xsl:template><xsl:template name="LISTADOAestilo">
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
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorborde"/></xsl:with-param>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>
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
         <xsl:with-param name="colborde"/>
         <xsl:with-param name="padding"/>
         <xsl:with-param name="ancho"><xsl:value-of select="PRESENTACION/@ancho + $vAncho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="imagen"/>
         <xsl:with-param name="repeat"/>      </xsl:call-template>


         
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
   </xsl:template><xsl:template name="LISTADOAinit">
      <xsl:call-template name="SCROLLinit">
         <xsl:with-param name="nombre"><xsl:value-of select="concat(@nombre,'scroll')"/></xsl:with-param>
      </xsl:call-template>
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template><xsl:template name="LISTADOAscript">
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


   
      <xsl:text>
</xsl:text>
      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($listadoascroll,'Div.document.')"/>
         <xsl:value-of select="concat($listadoascroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($capa-nsdoc-local,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>

      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_tabIndex=null;</xsl:text>

      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_ontab=null;</xsl:text>

      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_onshtab=null;</xsl:text>

      <xsl:if test="@tabIndex">
         <xsl:text>
</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>_tabIndex=</xsl:text>
         <xsl:value-of select="@tabIndex"/>
         <xsl:text>;
</xsl:text>
      </xsl:if>

      <xsl:if test="@ontab">
         <xsl:text>
</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>_ontab=true;
</xsl:text>
      </xsl:if>

      <xsl:if test="@onshtab">
         <xsl:text>
</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>_onshtab=true;
</xsl:text>
      </xsl:if>

      <xsl:value-of select="@nombre"/><xsl:text>=new ListadoA(</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>',</xsl:text>
      <xsl:value-of select="@multisel"/><xsl:text>,</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imagenoff"/><xsl:text>',</xsl:text>
      <xsl:text>'</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@imagenon"/><xsl:text>',</xsl:text>
      <xsl:value-of select="PRESENTACION/@bloquesid"/><xsl:text>,</xsl:text>

      <xsl:text>[</xsl:text> 
         <xsl:text>'</xsl:text><xsl:value-of select="PRESENTACION/@ancho"/><xsl:text>',</xsl:text>
         <xsl:for-each select="PRESENTACION/COL">
            <xsl:text>'</xsl:text><xsl:value-of select="@ancho"/><xsl:text>'</xsl:text>
            <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
         </xsl:for-each>
      <xsl:text>],</xsl:text>

      <xsl:text>[</xsl:text> 
         <xsl:text>'</xsl:text><xsl:value-of select="PRESENTACION/@filas"/><xsl:text>',</xsl:text>
         <xsl:for-each select="PRESENTACION/COL">
            <xsl:choose>
               <xsl:when test="position()=1">
                  <xsl:choose>
                     <xsl:when test="ancestor::LISTA/@multisel='0'">
                        <xsl:text>'</xsl:text><xsl:value-of select="@caracteres"/><xsl:text>',</xsl:text>
                     </xsl:when>
                     <xsl:otherwise>
                        <xsl:text/> 
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

      <xsl:text>[</xsl:text> 
      <xsl:for-each select="ROWSET/ROW">
         <xsl:text>[</xsl:text>
            <xsl:for-each select="CAMPO">

      <xsl:variable name="vContenido">
         <xsl:value-of select="concat(.,@VALOR)"/>
      </xsl:variable>
      <xsl:variable name="vContenido2">
         <xsl:value-of select="translate($vContenido, '&#xd;',' ')"/>
      </xsl:variable>
               
               <xsl:text>'</xsl:text>
               
               <xsl:call-template name="escapaCaracterYBarra">
                   <xsl:with-param name="text" select="translate($vContenido2, '&#xA;',' ')"/>
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

      
      <xsl:choose>
         <xsl:when test="@variableCache">             
            <xsl:text>,['</xsl:text>
            <xsl:value-of select="$frameCache"/><xsl:text>','</xsl:text>
            <xsl:value-of select="@rutaVariableCache"/><xsl:text>','</xsl:text>
            <xsl:value-of select="@variableCache"/>
            <xsl:text>']</xsl:text>                
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>,null</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 
      

      
      <xsl:choose>
         <xsl:when test="@pintadoSimplificado and @pintadoSimplificado='S'">,true</xsl:when>
         <xsl:otherwise>,false</xsl:otherwise>
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

	<xsl:if test="@onSetDatos and string-length(@onSetDatos) &gt; 0">
      <xsl:choose>
        <xsl:when test="$pGeneroHTML='S'">
           <xsl:value-of select="@nombre"/><xsl:text>.onSetDatos="";
</xsl:text>
        </xsl:when>
        <xsl:otherwise>
           <xsl:value-of select="@nombre"/><xsl:text>.onSetDatos="</xsl:text><xsl:value-of select="@onSetDatos"/><xsl:text>";
</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
	</xsl:if>      

	<xsl:if test="@blockImg and string-length(@blockImg) &gt; 0">
	   <xsl:value-of select="@nombre"/><xsl:text>.blockImg.src='</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@blockImg"/><xsl:text>';
</xsl:text>
	</xsl:if>      

	<xsl:if test="@estilosCeldas and string-length(@estilosCeldas) &gt; 0">
	   <xsl:value-of select="@nombre"/><xsl:text>.estilosCeldas="</xsl:text><xsl:value-of select="@estilosCeldas"/><xsl:text>";
</xsl:text>
	</xsl:if> 
   
	  <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) { 
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;}</xsl:text>
      </xsl:if>

      <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) { 
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (!shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;}</xsl:text>
      </xsl:if>

   

      <xsl:variable name="listascroll">
         <xsl:value-of select="concat(@nombre,'scroll')"/>
      </xsl:variable>


      <xsl:variable name="vAncho">
         <xsl:choose>
           <xsl:when test="$vIncY != 0">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      
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
      


   </xsl:template><xsl:template name="LISTADOAbody">
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



      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$capacapa"/>
         </xsl:attribute>

         <DIV>
            <xsl:attribute name="ID">
               <xsl:value-of select="$capacab"/>
            </xsl:attribute>

            <xsl:apply-templates select="CABECERA"/>


         </DIV> 

         
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

      </DIV>  

   </xsl:template><xsl:template name="LISTADOAdinamico">

      <xsl:if test="@onSetDatos and string-length(@onSetDatos) &gt; 0">
         <xsl:text>
DrMainEstatico.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>.onSetDatos='</xsl:text>
         <xsl:call-template name="escapa">
             <xsl:with-param name="text" select="translate(@onSetDatos, '&#xA;',' ')"/>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>';
</xsl:text>
      </xsl:if>

      <xsl:text>
DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.setDatos(</xsl:text>

      <xsl:text>[</xsl:text> 
      
      <xsl:for-each select="ROWSET/ROW">
         <xsl:text>[</xsl:text>
            <xsl:for-each select="CAMPO">
               <xsl:variable name="vContenido">
                  <xsl:value-of select="concat(.,@VALOR)"/>
               </xsl:variable>
               <xsl:variable name="vContenido2">
                  <xsl:value-of select="translate($vContenido, '&#xd;',' ')"/>
               </xsl:variable>
               <xsl:text>'</xsl:text>
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="translate($vContenido2, '&#xA;',' ')"/>
                   <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
               <xsl:text>'</xsl:text>
               <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
            </xsl:for-each>
         <xsl:text>]</xsl:text>
         <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>]</xsl:text>

      <xsl:text>);
DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.display();
</xsl:text>

   </xsl:template><xsl:template match="LISTA" mode="head">
   
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="LISTA" mode="estilo">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAestilo">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAestilo">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates mode="estilo">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template><xsl:template match="LISTA" mode="init">
      
      <xsl:if test="$vgQuieroDruidaBack='S'">
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/><xsl:value-of select="@seleccion"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAinit"/>
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAinit"/>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="LISTA" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:choose>
           <xsl:when test="@seleccion='fila'">
           </xsl:when>
           <xsl:otherwise>
               <xsl:call-template name="LISTADOAdinamico"/>
           </xsl:otherwise>
         </xsl:choose>
      </xsl:if>
      <xsl:apply-templates mode="dinamico"/>
   </xsl:template><xsl:template match="LISTA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>

      <xsl:variable name="nsdoc-local">

         <xsl:value-of select="concat($nsdoc,'.')"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAscript">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="LISTADOAscript">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc"/></xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose>


      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">



            <xsl:value-of select="$nsdoc"/>  

         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template><xsl:template match="LISTA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAbody">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAbody">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>


      <xsl:apply-templates mode="body">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template><xsl:template match="CABECERA">

      <xsl:variable name="vIncY">
         <xsl:choose>
            <xsl:when test="@incy">
               <xsl:value-of select="@incy"/>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vAncho">
         <xsl:choose>
            <xsl:when test="$vIncY != 0">16</xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
        
      <TABLE BGCOLOR="" BORDER="0" CELLPADDING="0" CELLSPACING="0">
         <xsl:attribute name="WIDTH">

            <xsl:value-of select="../PRESENTACION/@ancho + $vAncho"/>
         </xsl:attribute>
         <TR>
         <xsl:for-each select="COL">
            <TD ID="{@id}" WIDTH="{@ancho}">
               <IMG style="visibility:hidden" height="1">
                  <xsl:if test="@ancho">
                     <xsl:attribute name="width">
                        <xsl:value-of select="@ancho"/>
                     </xsl:attribute> 
                  </xsl:if> 
               </IMG><br/>
               <xsl:text disable-output-escaping="yes"> </xsl:text>
               <xsl:choose>
                  <xsl:when test="@tooltip">
                     <xsl:variable name="vTxt">
                        <xsl:call-template name="langtxt">
                           <xsl:with-param name="pCod" select="@tooltip"/>
                        </xsl:call-template>
                     </xsl:variable>

                     <A id="{@id}" href="javascript:void(null)" onmouseover="tooltip(event, '{$vTxt}')" onmouseout="tooltip()">
                        <xsl:apply-templates mode="body"/>
                     </A>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:apply-templates mode="body"/>
                  </xsl:otherwise>
               </xsl:choose> 
               <xsl:text disable-output-escaping="yes"> </xsl:text>
            </TD>
         </xsl:for-each>
         </TR>
      </TABLE>

   </xsl:template><xsl:template match="LISTA" mode="form">

      <xsl:if test="@seleccion='fila'">

         <xsl:for-each select="PRESENTACION/COL[@enviar='S']">
         <xsl:text>
   </xsl:text>
         <INPUT TYPE="hidden">
            <xsl:attribute name="NAME">
               <xsl:value-of select="../../@nombre"/><xsl:text>H</xsl:text><xsl:value-of select="position()"/>
            </xsl:attribute>
            <xsl:attribute name="VALUE"/>
         </INPUT>
         </xsl:for-each>

      </xsl:if>

   </xsl:template><xsl:template match="COL" mode="body">
   </xsl:template><xsl:template match="PAGINADO" mode="head">
   <SCRIPT TYPE="text/javascript">
      <xsl:attribute name="SRC">
         <xsl:value-of select="$jsDruidaPath"/>
         <xsl:text>d3pag.js</xsl:text>
      </xsl:attribute>
      <xsl:text> </xsl:text>
   </SCRIPT>
   <xsl:apply-templates mode="head"/>   
</xsl:template><xsl:template match="PAGINADO" mode="script">
     

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Paginado('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="@sep"/><xsl:text>','</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="BOTON[1]/@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="BOTON[2]/@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="@cargainicial"/><xsl:text>','</xsl:text><xsl:value-of select="@labelPag"/><xsl:text>','</xsl:text><xsl:value-of select="@labelUltima"/><xsl:text>');
</xsl:text>

   <xsl:if test="@onload">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.funcion="</xsl:text><xsl:value-of select="@onload"/><xsl:text>";
</xsl:text>
         </xsl:if>

   <xsl:if test="@valores and string-length(@valores)&gt;0">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.valores="</xsl:text><xsl:value-of select="@valores"/><xsl:text>";</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.ir1="N";</xsl:text>
   </xsl:if>


  <xsl:if test="@msjUltima and string-length(@msjUltima)&gt;0">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.msjUltima="</xsl:text><xsl:value-of select="@msjUltima"/><xsl:text>";</xsl:text>
   </xsl:if>

      <xsl:apply-templates mode="script">

      </xsl:apply-templates>

</xsl:template><xsl:template match="PAGINADO" mode="init">
   <xsl:if test="$vgQuieroDruidaBack='S'">
      
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>
   </xsl:if>
   <xsl:if test="not($pGeneroHTML='S')">
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:if>

   <xsl:apply-templates mode="init"/>
</xsl:template><xsl:template match="PAGINADO" mode="body">
    <xsl:apply-templates mode="body"/> 
</xsl:template><xsl:template match="PAGINADO" mode="dinamico">
   <xsl:if test="@drdModificado and @drdModificado='S'">
   
      <xsl:text>
DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_form.paginado_control.value='</xsl:text>
      <xsl:value-of select="@control"/>
      <xsl:text>';</xsl:text>
      <xsl:text>
DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_form.paginado_conector.value='</xsl:text>
      <xsl:value-of select="@conector"/>
      <xsl:text>';</xsl:text>
      <xsl:text>
DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>_form.paginado_idrowset.value='</xsl:text>
      <xsl:value-of select="@rowset"/>
      <xsl:text>';</xsl:text>

      <xsl:text>
DrMainEstatico.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.init();</xsl:text>
      <xsl:text>;</xsl:text>
   </xsl:if>
   <xsl:apply-templates mode="dinamico"/>
</xsl:template><xsl:template name="FORMULARIOFINALPAGINADO">
      <TABLE border="0" cellspaceng="0" cellpadding="0">
         <TR><TD>
         <FORM name="{@nombre}_form" METHOD="post" action="{$vgConfig/DATOSPROY/PROXYSERVLET}?ON=ObjetoPaginado">
            <INPUT TYPE="hidden" NAME="paginado_nombre" VALUE="{@nombre}"/>
            <INPUT TYPE="hidden" NAME="paginado_indice" VALUE=""/>
            <INPUT TYPE="hidden" NAME="paginado_control" VALUE="{@control}"/>
            <INPUT TYPE="hidden" NAME="paginado_conector" VALUE="{@conector}"/>
            <INPUT TYPE="hidden" NAME="paginado_idrowset" VALUE="{@rowset}"/>
            <xsl:if test="$vgTipoAsignarJs='AJAX'">
               <INPUT TYPE="hidden" NAME="tipoAsignar" value="AJAX"/>
               <INPUT TYPE="hidden" NAME="nombrePaginado" value="{@nombre}"/>
            </xsl:if>
            <xsl:text>
</xsl:text>
         </FORM>
         </TD></TR>
      </TABLE>
   </xsl:template><xsl:template match="FORMULARIO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="FORMULARIO" mode="init"> 
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="FORMULARIO" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="FORMULARIO" mode="script">
   
      <xsl:value-of select="@nombre"/>
      <xsl:text>=new drdFormulario("</xsl:text>
      <xsl:value-of select="$ProxyServlet"/>
      <xsl:text>","</xsl:text>
      <xsl:choose>
        <xsl:when test="@oculto"><xsl:value-of select="@oculto"/></xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose>
      <xsl:text>");</xsl:text>
     
      <xsl:apply-templates mode="script">

      </xsl:apply-templates>
   </xsl:template><xsl:template match="FORMULARIO" mode="body">
     
         <xsl:apply-templates mode="body">

         </xsl:apply-templates>
      </xsl:template><xsl:template match="FICHERO" mode="head">
      <xsl:if test="generate-id(//FICHERO[1]) = generate-id()">
         <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}fichero.js">
            
            <xsl:text> </xsl:text>
         </SCRIPT>
      </xsl:if>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="FICHERO" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>
#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="FICHERO" mode="init">
      
      <xsl:value-of select="@nombre"/>
      <xsl:text>.init();</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="FICHERO" mode="script">


     

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Fichero('</xsl:text>
      <xsl:value-of select="@nombre"/>

      <xsl:text>','</xsl:text>

      <xsl:choose>
         <xsl:when test="@funcion">
            <xsl:value-of select="@funcion"/>
            <xsl:text>');</xsl:text>
            <xsl:value-of select="@nombre"/><xsl:text>.isFunction=true;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@campo"/>
            <xsl:text>');</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 

      <xsl:if test="@onsubmit">
      <xsl:value-of select="@nombre"/><xsl:text>.onSubmit="</xsl:text><xsl:value-of select="@onsubmit"/><xsl:text>";</xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="FICHERO" mode="body">
      <xsl:choose>
         <xsl:when test="@x and @y">
            <DIV ID="{@nombre}CapRecipnt">
               <xsl:apply-templates select="." mode="elBodyNormal"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:apply-templates select="." mode="elBodyNormal"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="FICHERO" mode="elBodyNormal">

      <xsl:variable name="vNombreBoton">
         <xsl:choose>
            <xsl:when test="@texto">
               <xsl:value-of select="@texto"/>
            </xsl:when>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text>Subir</xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vComprimir">
         <xsl:choose>
            <xsl:when test="@comprimir">
               <xsl:value-of select="@comprimir"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text>no</xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vRuta">
         <xsl:choose>
            <xsl:when test="@drpath">
               <xsl:value-of select="@drpath"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vCopiar">
         <xsl:choose>
            <xsl:when test="@copiar">
               <xsl:value-of select="@copiar"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vTarget">
         <xsl:choose>
            <xsl:when test="@target">
               <xsl:value-of select="@target"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vDescomprimir">
         <xsl:choose>
            <xsl:when test="@descomprimir">
               <xsl:value-of select="@descomprimir"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text>no</xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vON">
         <xsl:choose>
            <xsl:when test="@ON">
               <xsl:value-of select="@ON"/>
            </xsl:when>
            <xsl:otherwise>ObjetoFichero</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <FORM name="{@nombre}_form" ACTION="{$ProxyServlet}?ON={$vON}" METHOD="post" ENCTYPE="multipart/form-data">

         <xsl:if test="@target">
            <xsl:attribute name="TARGET">
               <xsl:value-of select="$vTarget"/>
            </xsl:attribute>
         </xsl:if>

         <INPUT TYPE="hidden" NAME="comprimir" VALUE="{$vComprimir}"/><xsl:text> </xsl:text>
	      <INPUT TYPE="hidden" NAME="copiar" VALUE="{$vCopiar}"/><xsl:text> </xsl:text>
         <INPUT TYPE="hidden" NAME="descomprimir" VALUE="{$vDescomprimir}"/><xsl:text> </xsl:text>
         <INPUT TYPE="hidden" NAME="drpath" VALUE="{$vRuta}"/><xsl:text> </xsl:text>

         <INPUT TYPE="file" NAME="archivoPrincipal" SIZE="{@size}" MAXLENGTH="{@max}" onkeydown="this.blur()">
            <xsl:if test="@id">
               <xsl:attribute name="class">
                  <xsl:value-of select="@id"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:if test="@readonly or @onshtab">
               <xsl:attribute name="onkeydown">
                  <xsl:if test="@onshtab">window.event.cancelBubble=true;if (event.shiftKey &amp;&amp; event.keyCode==9){<xsl:value-of select="@onshtab"/>} </xsl:if>
                  <xsl:if test="@onshtab and @readonly"> else </xsl:if>
                  <xsl:if test="@readonly">onKeyDownFicheroReadOnly(this);</xsl:if>
               </xsl:attribute>
            </xsl:if>
         </INPUT>
         <xsl:text> </xsl:text>

       
         <INPUT TYPE="hidden" NAME="fichero_nombre" VALUE="{@nombre}"/><xsl:text> </xsl:text>

         <INPUT TYPE="button" NAME="boton_ok" VALUE="{$vNombreBoton}" ONCLICK="{@nombre}.submit();">
            <xsl:if test="@idenviar">
               <xsl:attribute name="class">
                  <xsl:value-of select="@idenviar"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:if test="not(@reset or @codReset) and @ontab">
               <xsl:attribute name="onkeydown">if (!event.shiftKey &amp;&amp; event.keyCode==9){<xsl:value-of select="@ontab"/>}</xsl:attribute>
            </xsl:if>
         </INPUT>
         <xsl:text> </xsl:text>

         <xsl:variable name="vReset">
            <xsl:choose>
               <xsl:when test="@codReset">
                  <xsl:call-template name="langtxt">
                     <xsl:with-param name="pCod" select="@codReset"/>
                  </xsl:call-template>
               </xsl:when>
               <xsl:when test="@reset">
                  <xsl:value-of select="@reset"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>Reset</xsl:text>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:variable> 

         <xsl:choose>
            <xsl:when test="@reset or @codReset">
               <INPUT TYPE="reset" NAME="boton_reset" value="{$vReset}">
                  <xsl:if test="@idenviar">
                     <xsl:attribute name="class">
                        <xsl:value-of select="@idenviar"/>
                     </xsl:attribute>
                  </xsl:if>
                  <xsl:if test="@ontab">
                     <xsl:attribute name="onkeydown">if (!event.shiftKey &amp;&amp; event.keyCode==9){<xsl:value-of select="@ontab"/>}</xsl:attribute>
                  </xsl:if>
               </INPUT>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose> 
     
     </FORM>

   </xsl:template><xsl:template match="TEXT" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="TEXT" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>
#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="TEXT" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S' and $vgQuieroDruidaBack='S'">
      
         <xsl:variable name="vNFormulario" select="ancestor::FORMULARIO/@nombre"/>
         <xsl:text>
DrMainEstatico.set('</xsl:text>
         <xsl:value-of select="$vNFormulario"/>
         <xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:call-template name="escapa">
            <xsl:with-param name="text">
               <xsl:if test="@trim = 'N'">
                  <xsl:value-of select="translate(@valor, '&#xA;',' ')"/>
               </xsl:if>
               <xsl:if test="not(@trim = 'N')">
                  <xsl:value-of select="normalize-space(translate(@valor, '&#xA;',' '))"/>
               </xsl:if>
            </xsl:with-param>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>

         <xsl:variable name="vValidDefecto" select="$vgCtexto"/>
         <xsl:text>DrMainEstatico.</xsl:text>
         <xsl:value-of select="$vNFormulario"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>TV='</xsl:text>
         <xsl:choose>
            <xsl:when test="string-length(@validacion)=0">
               <xsl:choose>
                  <xsl:when test="string-length($vValidDefecto)=0">
                     <xsl:text>null</xsl:text>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:call-template name="escapa">
                         <xsl:with-param name="text" select="normalize-space(translate( $vValidDefecto , '&#xA;',' '))"/>
                         <xsl:with-param name="caracter">'</xsl:with-param>
                     </xsl:call-template>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="normalize-space(translate( @validacion , '&#xA;',' '))"/>
                   <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose>
         <xsl:text>';</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="TEXT" mode="init">
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:if test="$vgQuieroDruidaBack='S'">
         
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
            <xsl:with-param name="text">
               <xsl:if test="@trim = 'N'">
                  <xsl:value-of select="translate(@valor, '&#xA;',' ')"/>
               </xsl:if>
               <xsl:if test="not(@trim = 'N')">
                  <xsl:value-of select="normalize-space(translate(@valor, '&#xA;',' '))"/>
               </xsl:if>
            </xsl:with-param>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>

      </xsl:if>
   </xsl:template><xsl:template match="TEXT" mode="script">
      
      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:variable name="iedoc">
         <xsl:for-each select="ancestor::TABLA">
            <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
         </xsl:for-each>
         <xsl:value-of select="@nombre"/>
      </xsl:variable>
      <xsl:variable name="vValidacionDefecto" select="$vgCtexto"/>
      <xsl:value-of select="$frmNombre"/><xsl:text>.rgElemFrm('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$iedoc"/>
      <xsl:text>','Texto',</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@msjreq) &gt; 0">
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>txtCmpReq</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>,"</xsl:text>
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
      <xsl:text>",'</xsl:text>
      <xsl:value-of select="@readonly"/>
      <xsl:text>','</xsl:text>
      <xsl:choose>
        <xsl:when test="@req='S'">C</xsl:when>
        <xsl:otherwise>c</xsl:otherwise>
      </xsl:choose>
      <xsl:text>',</xsl:text>
      <xsl:choose>
         <xsl:when test="@trim = 'N'">true</xsl:when>
         <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose>
      <xsl:text>);</xsl:text>

      

      
        <xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor){</xsl:text>
            <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',valor);</xsl:text>
            <xsl:value-of select="@onblur"/>
         <xsl:text>}</xsl:text>

      
      <xsl:if test="@onchange">
        <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor,objeto){</xsl:text>
               <xsl:text>set('</xsl:text>
               <xsl:value-of select="$frmNombre"/>
               <xsl:text>.</xsl:text>
               <xsl:value-of select="@nombre"/>
               <xsl:text>',valor);</xsl:text>
               <xsl:value-of select="@onchange"/>
         <xsl:text>}</xsl:text>
         </xsl:if>

      
         <xsl:if test="@onfocus">
        <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() { </xsl:text>
               <xsl:value-of select="@onfocus"/>
         <xsl:text>}</xsl:text>
         </xsl:if>

      
      <xsl:if test="@onkeypress and string-length(@onkeypress)&gt;0">
         <xsl:text>function fokp_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(){</xsl:text>
         <xsl:value-of select="@onkeypress"/>
         <xsl:text>}</xsl:text>
      </xsl:if>

      
      <xsl:if test="@onmax and string-length(@onmax)&gt;0">
         <xsl:text>function fonmax_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(){</xsl:text>
         <xsl:value-of select="@onmax"/>
         <xsl:text>}</xsl:text>
      </xsl:if>

      
      <xsl:if test="@onreturn and string-length(@onreturn)&gt;0">
         <xsl:text>function fonreturn_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){var codigoTecla=(window.Event)?e.which:event.keyCode;if (codigoTecla!=13){return true;}</xsl:text>
         <xsl:value-of select="@onreturn"/>
         <xsl:text>}</xsl:text>
      </xsl:if>

	  <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){var codigoTecla=(window.Event)?e.which:event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if (shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;}</xsl:text>
      </xsl:if>

      <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){var codigoTecla=(window.Event)?e.which:event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if (!shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;}</xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="TEXT" mode="body">
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
   </xsl:template><xsl:template match="TEXT" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 
      <INPUT>
         <xsl:if test="string-length($vToolTip)&gt;0">
            <xsl:attribute name="onMouseOver">
               <xsl:text>tooltip(event, '</xsl:text><xsl:value-of select="$vToolTip"/><xsl:text>')</xsl:text>
            </xsl:attribute> 
            <xsl:attribute name="onMouseOut">
               <xsl:text>tooltip()</xsl:text>
            </xsl:attribute> 
         </xsl:if> 
         <xsl:if test="@disabled and @disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>
         <xsl:attribute name="TYPE">
            <xsl:choose>
               <xsl:when test="@tipo and string-length(@tipo)&gt;0">
                  <xsl:value-of select="@tipo"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>text</xsl:text>
               </xsl:otherwise>
            </xsl:choose>
         </xsl:attribute>
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
            
            <xsl:value-of select="@valor"/>
         </xsl:attribute>
         <xsl:attribute name="SIZE">
            <xsl:value-of select="@size"/>
         </xsl:attribute>
         <xsl:attribute name="MAXLENGTH">
            <xsl:value-of select="@max"/>
         </xsl:attribute>

         <xsl:if test="string-length($vgColReq) &gt; 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:attribute name="onBlur">
         <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value);</xsl:text>
         </xsl:attribute>

         <xsl:choose>
            <xsl:when test="@onchange and string-length(@onchange)&gt;0">
               <xsl:attribute name="onChange">
                  <xsl:text>foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value,this);</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="$vgOnChangeCtexto">
                     <xsl:attribute name="onChange">
                        <xsl:value-of select="$vgOnChangeCtexto"/>
                     </xsl:attribute>
                  </xsl:when>
                  <xsl:otherwise/>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

         <xsl:attribute name="onFocus">
            <xsl:text>if (window.</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>RO=='S'<xsl:text>) {this.blur();return;}</xsl:text>
            <xsl:if test="@onfocus">
               <xsl:text>fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>();</xsl:text>
            </xsl:if>
			</xsl:attribute>

         <xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
            <xsl:attribute name="READONLY">
               <xsl:text/>
            </xsl:attribute>

            <xsl:if test="string-length($vgColReadOnly)&gt;0">
               <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
            </xsl:if>
         </xsl:if>

         <xsl:if test="@onkeypress">
            <xsl:attribute name="onKeyPress">
            <xsl:text>fokp_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:choose>
            <xsl:when test="@onmax and string-length(@onmax)&gt;0">
               <xsl:attribute name="onKeyUp">
                  <xsl:text>if (this.value.length==</xsl:text><xsl:value-of select="@max"/><xsl:text>) fonmax_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>();</xsl:text>
                  <xsl:if test="not(@onkeyup) and $vgOnKupCtexto">
                     <xsl:value-of select="$vgOnKupCtexto"/>
                  </xsl:if>
                  <xsl:text>return true;</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:when test="not(@onkeyup) and $vgOnKupCtexto">
               <xsl:attribute name="onKeyUp">
                  <xsl:value-of select="$vgOnKupCtexto"/>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise/>
         </xsl:choose>

         <xsl:if test="@onreturn or @ontab or @onshtab">
            <xsl:attribute name="onKeyDown">

            <xsl:text>set('</xsl:text>
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',this.value);</xsl:text>


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

         <xsl:if test="string-length($vgFormElementID)&gt;0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>

         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
               <xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

	      <xsl:if test="@id">
            <xsl:attribute name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

        <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
        </xsl:if>

      </INPUT>
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template><xsl:template match="TEXT" mode="form">
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
   </xsl:template><xsl:template match="CTEXTO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="CTEXTO" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="TEXT" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:variable name="vNFormulario" select="ancestor::FORMULARIO/@nombre"/>
         <xsl:text>
DrMainEstatico.set('</xsl:text>
         <xsl:value-of select="$vNFormulario"/>
         <xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:call-template name="escapa">
            <xsl:with-param name="text">
               <xsl:if test="@trim = 'N'">
                  <xsl:value-of select="translate(@valor, '&#xA;',' ')"/>
               </xsl:if>
               <xsl:if test="not(@trim = 'N')">
                  <xsl:value-of select="normalize-space(translate(@valor, '&#xA;',' '))"/>
               </xsl:if>
            </xsl:with-param>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>
         <xsl:variable name="vValidPorDefecto" select="$vgCtexto"/>
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
                         <xsl:with-param name="text" select="normalize-space(translate( $vValidPorDefecto , '&#xA;',' '))"/>
                         <xsl:with-param name="caracter">'</xsl:with-param>
                     </xsl:call-template>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="normalize-space(translate( @validacion , '&#xA;',' '))"/>
                   <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose>
         <xsl:text>';</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="CTEXTO" mode="init">
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:if test="$vgQuieroDruidaBack='S'">
         
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
            <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
            <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="CTEXTO" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>
</xsl:text>

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
      <xsl:text>';
</xsl:text>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>IE='</xsl:text>
      <xsl:value-of select="$iedoc"/>
      <xsl:text>';
</xsl:text>

      <xsl:if test="@trim = 'N'">
         <xsl:value-of select="$frmNombre"/>.<xsl:value-of select="@nombre"/><xsl:text>NOTRIM=true;
</xsl:text>
      </xsl:if>

      <xsl:choose>
         <xsl:when test="string-length(@msjreq) &gt; 0">
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>MR='</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>';
</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>MR='</xsl:text>
            <xsl:value-of select="$vgTxtCampoRequerido"/>
            <xsl:text>';
</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 


      <xsl:variable name="vValidacionDefecto" select="$vgCtexto"/>

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

      

      
        <xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor) { </xsl:text>
            <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',valor);</xsl:text>
            <xsl:value-of select="@onblur"/>
         <xsl:text> }
</xsl:text>

      
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

      
         <xsl:if test="@onfocus">
        <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() { </xsl:text>
               <xsl:value-of select="@onfocus"/>
         <xsl:text> }
</xsl:text>
         </xsl:if>

      
      <xsl:if test="@onkeypress and string-length(@onkeypress)&gt;0">
         <xsl:text>function fokp_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() { </xsl:text>
         <xsl:value-of select="@onkeypress"/>
         <xsl:text>}
</xsl:text>
      </xsl:if>

	  <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;}
</xsl:text>
      </xsl:if>

	  <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {
         if (ns) return true;
			var codigoTecla = (window.Event) ? e.which : event.keyCode;
         var shift_pul=(ie)?e.shiftKey:false;
			if (!shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;}
</xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="CTEXTO" mode="body">
      <INPUT>
         <xsl:attribute name="TYPE">
            <xsl:choose>
               <xsl:when test="@tipo and string-length(@tipo)&gt;0">
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

            <xsl:value-of select="@valor"/>
         </xsl:attribute>
         <xsl:attribute name="SIZE">
            <xsl:value-of select="@size"/>
         </xsl:attribute>
         <xsl:attribute name="MAXLENGTH">
            <xsl:value-of select="@max"/>
         </xsl:attribute>

         <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

         <xsl:if test="string-length($vgColReq) &gt; 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:attribute name="onBlur">
         <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value);</xsl:text>
         </xsl:attribute>

         <xsl:choose>
            <xsl:when test="@onchange and string-length(@onchange)&gt;0">
               <xsl:attribute name="onChange">
                  <xsl:text>foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value,this);</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="$vgOnChangeCtexto">
                     <xsl:attribute name="onChange">
                        <xsl:value-of select="$vgOnChangeCtexto"/>
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

         <xsl:if test="not(@onkeyup) and $vgOnKupCtexto">
            <xsl:attribute name="onKeyUp">
               <xsl:value-of select="$vgOnKupCtexto"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
               <xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

	      <xsl:if test="@id">
            <xsl:attribute name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

        <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
        </xsl:if>
         
      </INPUT>
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template><xsl:template match="CTEXTO" mode="form">
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
   </xsl:template><xsl:template match="AREATEXTO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="AREATEXTO" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>
#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="AREATEXTO" mode="script">
      
      <xsl:variable name="iedoc">
         <xsl:for-each select="ancestor::TABLA">
            <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
         </xsl:for-each>
         <xsl:value-of select="@nombre"/>
      </xsl:variable>

      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:variable name="vValidacionDefecto" select="$vgValidTextArea"/>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.rgElemFrm('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$iedoc"/>
      <xsl:text>','Textarea',</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@msjreq) &gt; 0">
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>txtCmpReq</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>,"</xsl:text>
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
      <xsl:text>",null,'</xsl:text> 
      <xsl:choose>
        <xsl:when test="@req='S'">C</xsl:when>
        <xsl:otherwise>c</xsl:otherwise>
      </xsl:choose>
      <xsl:text>',</xsl:text>
      <xsl:choose>
        <xsl:when test="@trim = 'N'">true</xsl:when>
        <xsl:otherwise>null</xsl:otherwise>
      </xsl:choose>
      <xsl:text>);</xsl:text>
   
       
      
         <xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(valor){</xsl:text>
         <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>',valor);</xsl:text>
         <xsl:value-of select="@onblur"/>
         <xsl:text>} </xsl:text>

      
         <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(valor,objeto){</xsl:text>
         <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>',valor);</xsl:text>
         <xsl:value-of select="@onchange"/>
         <xsl:text>} </xsl:text>

      
      <xsl:if test="@onfocus and string-length(@onfocus)&gt;0">
         <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(){</xsl:text>
         <xsl:value-of select="@onfocus"/>
         <xsl:text>} </xsl:text>
      </xsl:if>

      
      <xsl:if test="@onkeydown and string-length(@onkeydown)&gt;0">
         <xsl:text>function fokd_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(){</xsl:text>
         <xsl:value-of select="@onkeydown"/>
         <xsl:text>} </xsl:text>
      </xsl:if>


      
	   <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if (shift_pul||codigoTecla!=9){return true;} </xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

      
	   <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if(!shift_pul||codigoTecla!=9){return true;} </xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

      
      <xsl:if test="(@onkeyup and string-length(@onkeyup)&gt;0) or (@max and string-length(@max)&gt;0)">
         <xsl:text>function foku_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(valor){</xsl:text>
         <xsl:value-of select="@onkeyup"/>
         <xsl:text>;LimitaAreatexto('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>',valor,</xsl:text>
         <xsl:value-of select="@max"/>
         <xsl:text>)} </xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="AREATEXTO" mode="body">
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
   </xsl:template><xsl:template match="AREATEXTO" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 

      <TEXTAREA>

         <xsl:if test="@disabled and @disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>

         <xsl:if test="string-length($vToolTip)&gt;0"> 
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
            <xsl:when test="@onchange and string-length(@onchange)&gt;0">
               <xsl:attribute name="onChange">
                  <xsl:text>foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(this.value,this);</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="$vgOnChangeCtexto">
                     <xsl:attribute name="onChange">
                        <xsl:value-of select="$vgOnChangeCtexto"/>
                     </xsl:attribute>
                  </xsl:when>
                  <xsl:otherwise/>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:if test="@onfocus and string-length(@onfocus)&gt;0">
            <xsl:attribute name="onFocus">
               <xsl:text>fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>





         
         <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
         </xsl:if>

         <xsl:if test="@onkeydown or @ontab or @onshtab">
            <xsl:attribute name="onKeyDown">
            
            

               <xsl:if test="@onkeydown and string-length(@onkeydown)&gt;0">
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



         <xsl:choose>
            <xsl:when test="(@onkeyup and string-length(@onkeyup)&gt;0) or (@max and string-length(@max)&gt;0)">
               <xsl:attribute name="onkeyup">
                  <xsl:text>foku_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(this.value);</xsl:text>
               </xsl:attribute>
            </xsl:when>
            <xsl:when test="$vgOnKupTextArea">
               <xsl:attribute name="onkeyup">
                  <xsl:value-of select="$vgOnKupTextArea"/>
               </xsl:attribute>
            </xsl:when>
            <xsl:otherwise/>
         </xsl:choose>


         <xsl:if test="string-length($vgFormElementID)&gt;0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>

         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
               <xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@id">
            <xsl:attribute name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

<xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
			<xsl:attribute name="READONLY">
               <xsl:text/>
            </xsl:attribute>
            <xsl:attribute name="onFocus">
            <xsl:text>this.blur();</xsl:text>
            </xsl:attribute>

         <xsl:if test="string-length($vgColReadOnly)&gt;0">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
         </xsl:if>

 </xsl:if>

         <xsl:if test="string-length($vgColReq) &gt; 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:variable name="vTexto" select="concat(., @valor)"/>
         
         <xsl:choose>
            <xsl:when test="$vTexto and string-length($vTexto)&gt;0">
               <xsl:value-of select="$vTexto" disable-output-escaping="yes"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text/>
            </xsl:otherwise>
         </xsl:choose> 


      </TEXTAREA>
      <xsl:call-template name="CAMPOREQ"/>
   </xsl:template><xsl:template match="AREATEXTO" mode="form">

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
   </xsl:template><xsl:template match="CHECKBOX" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="CHECKBOX" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>
#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="CHECKBOX" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:if test="@check and @check='S'">
            <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
            <xsl:text>
DrMainEstatico.set('</xsl:text>
            <xsl:value-of select="$vNombreFormulario"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>','S');</xsl:text>
         </xsl:if>
      </xsl:if>
   </xsl:template><xsl:template match="CHECKBOX" mode="init">

      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:if test="$vgQuieroDruidaBack='S'">
         
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="$vNombreFormulario"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="CHECKBOX" mode="script">
      

      <xsl:variable name="iedoc">
         <xsl:for-each select="ancestor::TABLA">
            <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
         </xsl:for-each>
         <xsl:value-of select="@nombre"/>
      </xsl:variable>

      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.rgElemFrm('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$iedoc"/>
      <xsl:text>','Checkbox',</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@msjreq) &gt; 0">
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>txtCmpReq</xsl:otherwise>
      </xsl:choose>
      <xsl:text>,"</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@validacion)=0">
            <xsl:text>null</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@validacion"/>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>",null,</xsl:text>
      <xsl:choose>
        <xsl:when test="@req='S'">'C'</xsl:when>
        <xsl:otherwise>'c'</xsl:otherwise>
      </xsl:choose>
      <xsl:text>);</xsl:text>
   

       

      
      <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(){</xsl:text>
      <xsl:text>set('</xsl:text>
      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>',null);</xsl:text>
      <xsl:value-of select="@onclick"/>
      <xsl:text> } </xsl:text>

      
      <xsl:if test="@onfocus and string-length(@onfocus)&gt;0">
         <xsl:text>function fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>(){</xsl:text>
         <xsl:text>set('</xsl:text>
         <xsl:value-of select="$frmNombre"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>',null);</xsl:text>
         <xsl:value-of select="@onfocus"/>
         <xsl:text>} </xsl:text>
      </xsl:if>

      
	   <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if (shift_pul||codigoTecla!=9){return true;} </xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

      
	   <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if(!shift_pul||codigoTecla!=9){return true;} </xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="CHECKBOX" mode="body">
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
   </xsl:template><xsl:template match="CHECKBOX" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 

	  <INPUT TYPE="checkbox">

         <xsl:if test="@disabled and @disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>

         <xsl:if test="string-length($vToolTip)&gt;0">
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

         <xsl:if test="@onfocus and string-length(@onfocus)&gt;0">
            <xsl:attribute name="onFocus">
               <xsl:text>fof_</xsl:text><xsl:value-of select="@nombre"/><xsl:number/><xsl:text>();</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@check='S'">
            <xsl:attribute name="CHECKED"/>
         </xsl:if>

         <xsl:if test="string-length($vgFormElementID)&gt;0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>

         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
               <xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@id">
            <xsl:attribute name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>


         <xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
            <xsl:attribute name="onClick">
		   <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',document.</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.value);</xsl:text>
            </xsl:attribute>
         <xsl:if test="string-length($vgColReadOnly)&gt;0">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
         </xsl:if>
         </xsl:if>

         <xsl:if test="string-length($vgColReq) &gt; 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         
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
         <xsl:when test="string-length($vgRadioCheckColorOnText)&gt;0 and $vgRadioCheckColorOnText='S'">
	         <xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
			 <SPAN>
				<xsl:if test="string-length($vgFormElementID)&gt;0">
				  <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
				</xsl:if>

				 <xsl:if test="(@readonly and @readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
					<xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
				 </xsl:if>

				   <xsl:if test="string-length($vgColReq) &gt; 0 and @req='S'">
				<xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
			 </xsl:if>
				<xsl:value-of select="@texto" disable-output-escaping="yes"/>
				</SPAN>
		   <xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
         </xsl:when>

         <xsl:when test="@id">
            <SPAN ID="{@id}"><xsl:value-of select="@texto" disable-output-escaping="yes"/></SPAN>
         </xsl:when>

         <xsl:otherwise>
				<xsl:value-of select="@texto" disable-output-escaping="yes"/>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:call-template name="CAMPOREQ"/>
   </xsl:template><xsl:template match="CHECKBOX" mode="form">
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
   </xsl:template><xsl:template match="COMBO" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="COMBO" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>
#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="COMBO" mode="init">

      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:if test="$vgQuieroDruidaBack='S'">
         
         <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
         <xsl:value-of select="name()"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="$vNombreFormulario"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>'];</xsl:text>
      </xsl:if>
      <xsl:variable name="vInicial">
         <xsl:choose>
            <xsl:when test="@multiple='S'">
               <xsl:for-each select="ROWSET/ROW[@check='S']">
                  <xsl:sort select="position()" data-type="text" order="descending"/> 
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

   </xsl:template><xsl:template match="COMBO" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      

         
         <xsl:text>
</xsl:text> 
         <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>

         <xsl:variable name="vInicial">
            <xsl:choose>
               <xsl:when test="@multiple='S'">
                  <xsl:for-each select="ROWSET/ROW[@check='S']">
                     <xsl:sort select="position()" data-type="text" order="descending"/> 
                     
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
                  <xsl:text/><xsl:value-of select="$vInicial"/><xsl:text/>       
              </xsl:otherwise>
            </xsl:choose> 
         </xsl:variable> 

         
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
               <xsl:if test="count(ROWSET/ROW)&gt;0"><xsl:text>,</xsl:text></xsl:if> 
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
            
         
         <xsl:variable name="vValorInicial">
            <xsl:choose>
              <xsl:when test="$valorinicialtest='true'">
                  <xsl:text>'</xsl:text><xsl:value-of select="@valorinicial"/><xsl:text>'</xsl:text>
              </xsl:when>
              <xsl:otherwise><xsl:text>null</xsl:text></xsl:otherwise>
            </xsl:choose> 
         </xsl:variable>

         <xsl:text>
DrMainEstatico.</xsl:text>      
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

         <xsl:text>
DrMainEstatico.</xsl:text>      
         <xsl:value-of select="$vNombreFormulario"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>textoinicial=</xsl:text><xsl:value-of select="$vTextoInicial"/><xsl:text>;</xsl:text>

         <xsl:if test="ROWSET/ROW[@check='S']">
            <xsl:text>
DrMainEstatico.set('</xsl:text>
            <xsl:value-of select="$vNombreFormulario"/>
            <xsl:text>.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>',[</xsl:text>
            <xsl:for-each select="ROWSET/ROW[@check='S']">
               <xsl:sort select="position()" data-type="text" order="descending"/> 
               <xsl:text>'</xsl:text>
               <xsl:value-of select="concat(CAMPO[1],CAMPO[1]/@VALOR)"/>
               <xsl:text>'</xsl:text>
               <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if> 
            </xsl:for-each>
            <xsl:text>]);</xsl:text>
         </xsl:if>

      </xsl:if>
   </xsl:template><xsl:template match="COMBO" mode="script">
      
      <xsl:variable name="iedoc">
         <xsl:for-each select="ancestor::TABLA">
            <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
         </xsl:for-each>
         <xsl:value-of select="@nombre"/>
      </xsl:variable>

      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

      
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


      <xsl:value-of select="$frmNombre"/><xsl:text>.rgElemFrm('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
         <xsl:value-of select="$iedoc"/>
      <xsl:text>','Combo',</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@msjreq) &gt; 0">
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>txtCmpReq</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>,"</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@validacion)=0">
            <xsl:text>null</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@validacion"/>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>",'</xsl:text>
      
      <xsl:text>','</xsl:text>
      <xsl:choose>
         <xsl:when test="@req='S'">C</xsl:when>
         <xsl:otherwise>c</xsl:otherwise>
      </xsl:choose>
      <xsl:text>',null,</xsl:text>      
         <xsl:value-of select="@size"/>
      <xsl:text>,</xsl:text>
         <xsl:value-of select="$vValorInicial"/>
      <xsl:text>,</xsl:text>
         <xsl:value-of select="$vTextoInicial"/>
      <xsl:text>);
</xsl:text>

      

      
      <xsl:text>function fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(){</xsl:text>
      <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',null);}
</xsl:text>

      
      <xsl:if test="@onchange">
         <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>() {</xsl:text>
            <xsl:text>set('</xsl:text><xsl:value-of select="$frmNombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>',null);</xsl:text>
            <xsl:value-of select="@onchange"/><xsl:text>}
</xsl:text>
      </xsl:if>

      
      <xsl:if test="@onreturn and string-length(@onreturn)&gt;0">
         <xsl:text>function fonreturn_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;if(codigoTecla!=13){return true;}</xsl:text>
         <xsl:value-of select="@onreturn"/>
         <xsl:text>}
</xsl:text>
      </xsl:if>

	  <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if(shift_pul||codigoTecla!=9){return true;};</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;}
</xsl:text>
      </xsl:if>

	  <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e) {var codigoTecla = (window.Event) ? e.which : event.keyCode;var shift_pul=(ie)?e.shiftKey:false;if (!shift_pul || codigoTecla!=9) {return true;}
</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

   </xsl:template><xsl:template match="COMBO" mode="body">
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
   </xsl:template><xsl:template match="COMBO" mode="bodyNormal">
      <xsl:variable name="vToolTip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 

      <SELECT NAME="{@nombre}" SIZE="{@size}">

         <xsl:if test="@disabled and @disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>

         <xsl:if test="string-length($vToolTip)&gt;0">
            <xsl:attribute name="onMouseOver">
               <xsl:text>tooltip(event, '</xsl:text><xsl:value-of select="$vToolTip"/><xsl:text>')</xsl:text>
            </xsl:attribute> 
            <xsl:attribute name="onMouseOut">
               <xsl:text>tooltip()</xsl:text>
            </xsl:attribute> 
         </xsl:if> 
         <xsl:if test="@multiple='S'">
            <xsl:attribute name="MULTIPLE"/>
         </xsl:if>
         <xsl:attribute name="onBlur">
            <xsl:text>fob_</xsl:text><xsl:value-of select="@nombre"/><xsl:text> ();</xsl:text>
         </xsl:attribute>

         
         <xsl:if test="@tabIndex">
            <xsl:copy-of select="@tabIndex"/>
         </xsl:if>

         
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
            <xsl:attribute name="onFocus">
               <xsl:value-of select="@onfocus"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="@onchange">
            <xsl:attribute name="onChange">
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
            <xsl:if test="string-length($vgColReadOnly)&gt;0">
               <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
            </xsl:if>
         </xsl:if>

         <xsl:if test="string-length($vgFormElementID)&gt;0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>

         <xsl:if test="@id and string-length(@id)&gt;0">
            <xsl:attribute name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="string-length($vgColReq) &gt; 0 and @req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>

         <xsl:text>
</xsl:text>


         <xsl:variable name="vInicial">
            <xsl:choose>
              <xsl:when test="@valorinicial='00'"/> 
              <xsl:otherwise><xsl:value-of select="@valorinicial"/></xsl:otherwise>
            </xsl:choose> 
         </xsl:variable> 

         
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
                  <xsl:text>
</xsl:text>
               </xsl:when>
               <xsl:otherwise>
                  <OPTION VALUE="{CAMPO[1]}">
                     <xsl:if test="@check='S'">
                        <xsl:attribute name="SELECTED"/>
                     </xsl:if>
                     <xsl:value-of select="CAMPO[2]" disable-output-escaping="yes"/>
                  </OPTION>
                  <xsl:text>
</xsl:text>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:for-each>

      </SELECT>
      <xsl:text>
</xsl:text>
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template><xsl:template match="COMBO" mode="form">
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
   </xsl:template><xsl:template match="TABLA" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="TABLA" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="TABLA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">

         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>
</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Object();</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.TC='Tabla';</xsl:text>

      
      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template><xsl:template match="TABLA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      
      <TABLE>
         
         <xsl:copy-of select="@*[not(local-name()='nombre')]"/>

         <FORM ACTION="javascript:;">
            <xsl:attribute name="NAME">
               <xsl:value-of select="@nombre"/>
            </xsl:attribute>

            <xsl:apply-templates mode="body">
               <xsl:with-param name="nsdoc">
                  <xsl:value-of select="$nsdoc-local"/>
               </xsl:with-param>
            </xsl:apply-templates>

         </FORM>

      </TABLE>
   </xsl:template><xsl:template match="RBINPUT" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="RBINPUT" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="RBINPUT" mode="script">
      

        

      
      <xsl:if test="@onfocus and string-length(@onfocus)&gt;0">
         <xsl:text>function fof_</xsl:text><xsl:value-of select="../@nombre"/><xsl:number/><xsl:text>(){</xsl:text>
          <xsl:value-of select="@onfocus"/>
         <xsl:text>}
</xsl:text>
      </xsl:if>

        <xsl:apply-templates mode="script"/>
   </xsl:template><xsl:template match="RBINPUT" mode="body">
      <xsl:variable name="vToolTip">
         <xsl:if test="@tooltip and string-length(@tooltip)&gt;0">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable> 

      <INPUT TYPE="radio">

         <xsl:if test="../@disabled and ../@disabled='S'">
            <xsl:attribute name="DISABLED"/>
         </xsl:if>

         <xsl:if test="string-length($vToolTip)&gt;0">
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
         <xsl:if test="string-length($vgFormElementID)&gt;0">
            <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
         </xsl:if>
         <xsl:if test="../@id!=''">
            <xsl:attribute name="ID">
               <xsl:value-of select="../@id"/>
            </xsl:attribute>
         </xsl:if>
         <xsl:if test="@id">
            <xsl:attribute name="ID">
               <xsl:value-of select="@id"/><xsl:text>F</xsl:text>
            </xsl:attribute>
         </xsl:if>
         <xsl:if test="string-length($vgColReq) &gt; 0 and ../@req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>
         <xsl:if test="@check='S'">
            <xsl:attribute name="CHECKED"/>
         </xsl:if>

         <xsl:attribute name="onClick">
			 <xsl:choose>
				<xsl:when test="@onclick and string-length(@onclick)&gt;0">
					<xsl:text>if (</xsl:text><xsl:value-of select="@onclick"/><xsl:text>) {foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(this.value);return true;} else {foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>('');return false;}</xsl:text>
				</xsl:when>
			   <xsl:otherwise>
					<xsl:text>foc_</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>(this.value);</xsl:text>
					<xsl:text>return true;</xsl:text>
			   </xsl:otherwise>
			 </xsl:choose>      
   		</xsl:attribute>
         <xsl:if test="@onfocus and string-length(@onfocus)&gt;0">
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
      
			   <xsl:attribute name="onFocus">
            </xsl:attribute>

            <xsl:if test="string-length($vgColReadOnly)&gt;0">
               <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
            </xsl:if>

         </xsl:if>


         
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

         <xsl:when test="string-length($vgRadioCheckColorOnText)&gt;0 and $vgRadioCheckColorOnText='S'">
	   <xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
	   <SPAN>
			<xsl:if test="string-length($vgFormElementID)&gt;0">
			  <xsl:attribute name="ID"><xsl:value-of select="$vgFormElementID"/><xsl:text>F</xsl:text></xsl:attribute>			
			</xsl:if>

			 <xsl:if test="(../@readonly and ../@readonly='S') or (ancestor::FORMULARIO/@readonly and ancestor::FORMULARIO/@readonly='S')">
				<xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReadOnly"/></xsl:attribute>
			 </xsl:if>

	           <xsl:if test="string-length($vgColReq) &gt; 0 and ../@req='S'">
            <xsl:attribute name="style">background-color:<xsl:value-of select="$vgColReq"/></xsl:attribute>
         </xsl:if>
      
      <xsl:apply-templates select="." mode="elTexto"/>
      </SPAN>
	   <xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
		      
  		      <xsl:apply-templates select="." mode="elTexto"/>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:if test="../@tipo='V'"><br/></xsl:if>
   </xsl:template><xsl:template match="RBINPUT" mode="elTexto">
      <xsl:variable name="elTextoDelRb">
         <xsl:choose>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:apply-templates mode="body"/>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:choose>
         <xsl:when test="@id">
            <SPAN ID="{@id}">
               <xsl:value-of select="$elTextoDelRb"/>
            </SPAN>
         </xsl:when>
         <xsl:when test="../@id">
            <SPAN ID="{../@id}">
               <xsl:value-of select="$elTextoDelRb"/>
            </SPAN>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$elTextoDelRb"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="RADIOB" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="RADIOB" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>
#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="RADIOB" mode="script">
      
      <xsl:variable name="iedoc">
         <xsl:for-each select="ancestor::TABLA">
            <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
         </xsl:for-each>
         <xsl:value-of select="@nombre"/>
      </xsl:variable>

      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>

      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.rgElemFrm('</xsl:text>
      <xsl:value-of select="@nombre"/>
      
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$iedoc"/>
      <xsl:text>','Radio',</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@msjreq) &gt; 0">
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@msjreq"/>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>txtCmpReq</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>,"</xsl:text>
      <xsl:choose>
         <xsl:when test="string-length(@validacion)=0">
            <xsl:text>null</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@validacion"/>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>",null,'</xsl:text>
      <xsl:choose>
         <xsl:when test="@req='S'">C</xsl:when>
         <xsl:otherwise>c</xsl:otherwise>
      </xsl:choose>
      <xsl:text>');
</xsl:text>

       

      

      
      <xsl:text>function foc_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(valor){</xsl:text>
      <xsl:text>set('</xsl:text>
      <xsl:value-of select="$frmNombre"/>
      <xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>',valor);</xsl:text>
      <xsl:value-of select="@onclick"/>
      <xsl:text>}
</xsl:text>

      
      <xsl:if test="@ontab and string-length(@ontab)&gt;0">
         <xsl:text>function fontab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if(shift_pul||codigoTecla!=9){return true;}</xsl:text>
         <xsl:value-of select="@ontab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>

      <xsl:if test="@onshtab and string-length(@onshtab)&gt;0">
         <xsl:text>function fonshtab_</xsl:text><xsl:value-of select="@nombre"/><xsl:text>(e){codigoTecla=(window.Event)?e.which:event.keyCode;shift_pul=(ie)?e.shiftKey:false;if(!shift_pul||codigoTecla!=9){return true;}</xsl:text>
         <xsl:value-of select="@onshtab"/>
         <xsl:text>;event.returnValue=false;} </xsl:text>
      </xsl:if>


     <xsl:apply-templates mode="script">
      
      </xsl:apply-templates>
   </xsl:template><xsl:template match="RADIOB" mode="script-elem-form">
      
      <xsl:apply-templates mode="script-elem-form">
         
      </xsl:apply-templates>

   </xsl:template><xsl:template match="RADIOB" mode="body">
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
   </xsl:template><xsl:template match="RADIOB" mode="bodyNormal">
      <xsl:apply-templates select="RBINPUT" mode="body"/>
      
      <xsl:call-template name="CAMPOREQ"/>

   </xsl:template><xsl:template match="RADIOB" mode="form">
      <INPUT TYPE="hidden">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
            <xsl:value-of select="RBINPUT[@check='S']/@valor"/>
         </xsl:attribute>
      </INPUT>
   </xsl:template><xsl:template match="IMAGEN" mode="estilo">
      <xsl:choose>
         <xsl:when test="@version and @version='3.1'"><xsl:apply-templates select="." mode="estilo_31"/></xsl:when>
         <xsl:otherwise><xsl:apply-templates select="." mode="estilo_old"/></xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="IMAGEN" mode="script">
      <xsl:choose>
         <xsl:when test="@version and @version='3.1'"><xsl:apply-templates select="." mode="script_31"/></xsl:when>
         <xsl:otherwise><xsl:apply-templates select="." mode="script_old"/></xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="IMAGEN" mode="body">
      <xsl:choose>
         <xsl:when test="@version and @version='3.1'"><xsl:apply-templates select="." mode="body_31"/></xsl:when>
         <xsl:otherwise><xsl:apply-templates select="." mode="body_old"/></xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template match="IMAGEN" mode="estilo_31">

      <xsl:text>
#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:if test="(@x and not(@x='')) or (@y and not(@y=''))">
         <xsl:text>position:absolute;</xsl:text>
      </xsl:if>
      <xsl:if test="@ancho and not(@ancho='')">
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:if test="@alto and not(@alto='')">
         <xsl:text>height:</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:if test="@x and not(@x='')">
         <xsl:text>left:</xsl:text>
         <xsl:value-of select="@x"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:if test="@y and not(@y='')">
         <xsl:text>top:</xsl:text>
         <xsl:value-of select="@y"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:text>}</xsl:text>
   </xsl:template><xsl:template match="IMAGEN" mode="script_31">
   </xsl:template><xsl:template match="IMAGEN" mode="body_31">
       <div ID="{@nombre}Div">
         <img src="{$vgImgPath}{@img}">
            <xsl:if test="@ancho and not(@ancho='')">
               <xsl:attribute name="width">
                  <xsl:value-of select="@ancho"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:if test="@alto and not(@alto='')">
               <xsl:attribute name="height">
                  <xsl:value-of select="@alto"/>
               </xsl:attribute>
            </xsl:if>
         </img>
       </div>
   </xsl:template><xsl:template match="IMAGEN" mode="estilo_old">
      <xsl:text>
</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;}</xsl:text>
   </xsl:template><xsl:template match="IMAGEN" mode="script_old">
      <xsl:text>
</xsl:text>
      <xsl:variable name="nsdoc">
         <xsl:for-each select="ancestor::*">
            <xsl:if test="name()!='PAGINA'">
               <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
            </xsl:if>
         </xsl:for-each>
         <xsl:if test="@x!='' or @y!=''"> 
            <xsl:text>document.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>Div</xsl:text>
         </xsl:if>
         <xsl:text>.document.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>I</xsl:text>
      </xsl:variable>
      <xsl:text>
</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>= new Boton('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="$nsdoc"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="@img"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="@tipo"/>
      <xsl:text>',</xsl:text>
      <xsl:choose>
         <xsl:when test="@tipo &lt; 1">
            <xsl:text>false</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@estado"/>
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

      
      <xsl:text>function drdOnLoad() {</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.init();}
</xsl:text>

      <xsl:apply-templates mode="script"/>

   </xsl:template><xsl:template match="IMAGEN" mode="body_old">
      <xsl:choose>
         <xsl:when test="@x!='' or @y!=''">
            <DIV>
               <xsl:call-template name="IMAGEN"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="IMAGEN"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template name="IMAGEN">
      <xsl:attribute name="ID">
         <xsl:value-of select="@nombre"/>
         <xsl:text>Div</xsl:text>
      </xsl:attribute>

      <A HREF="javascript:void(null);">
         <xsl:attribute name="onClick">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.click();return false;</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onMouseOver">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.onMouseOver();</xsl:text>

            <xsl:if test="@alt!=''">
               <xsl:text>window.status='</xsl:text>
               <xsl:value-of select="@alt"/>
               <xsl:text>';return true;</xsl:text>
            </xsl:if>
         </xsl:attribute>

         <xsl:attribute name="onMouseOut">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.onMouseOut()</xsl:text>
         </xsl:attribute>


         <xsl:choose>
            <xsl:when test="@tipo=0">
               <xsl:call-template name="IMAGEN-IMAGEN">
                  <xsl:with-param name="img0" select="0"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="@estado=true">
                     <xsl:call-template name="IMAGEN-IMAGEN">
                        <xsl:with-param name="img0" select="3"/>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:call-template name="IMAGEN-IMAGEN">
                        <xsl:with-param name="img0" select="1"/>
                     </xsl:call-template>
                  </xsl:otherwise>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </A>
   </xsl:template><xsl:template name="IMAGEN-IMAGEN">
      <xsl:param name="img0"/>
      <IMG BORDER="0">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
            <xsl:text>I</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="SRC">
            <xsl:value-of select="@img"/>
            <xsl:value-of select="$img0"/>
            <xsl:text>.gif</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="ALT">
            <xsl:value-of select="@alt"/>
         </xsl:attribute>
      </IMG>
   </xsl:template><xsl:template match="CALENDARIO" mode="head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3calendario.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="CALENDARIO" mode="estilo">


      <xsl:if test="@mostrarmeses='3'">
         
         <xsl:call-template name="CALENDARIOestilo">
           <xsl:with-param name="pNombre" select="concat(@nombre,'anterior')"/>
           <xsl:with-param name="pX" select="@x - @ancho"/>
         </xsl:call-template>
         <xsl:call-template name="CALENDARIOestilo">
           <xsl:with-param name="pNombre" select="concat(@nombre,'siguiente')"/>
           <xsl:with-param name="pX" select="@x + @ancho"/>
         </xsl:call-template>
      </xsl:if> 
      
      
      <xsl:call-template name="CALENDARIOestilo"/>

   </xsl:template><xsl:template match="CALENDARIO" mode="init">
      <xsl:if test="@mostrarmeses='3'">
         
         <xsl:value-of select="concat(@nombre,'anterior')"/><xsl:text>.init();</xsl:text>
         <xsl:value-of select="concat(@nombre,'siguiente')"/><xsl:text>.init();</xsl:text>
      </xsl:if> 
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template><xsl:template match="CALENDARIO" mode="script">



      <xsl:if test="@mostrarmeses='3'">
         
         <xsl:call-template name="CALENDARIOscript">
            <xsl:with-param name="pNombre" select="concat(@nombre,'anterior')"/>
            <xsl:with-param name="pDia" select="'-1'"/>
            <xsl:with-param name="pMes" select="@mes - 1"/>
            <xsl:with-param name="pAccion" select="'null'"/>
            <xsl:with-param name="pMostrarMeses" select="'null'"/>
            <xsl:with-param name="pDesplazamiento" select="'null'"/>

         </xsl:call-template>
         <xsl:call-template name="CALENDARIOscript">
            <xsl:with-param name="pNombre" select="concat(@nombre,'siguiente')"/>
            <xsl:with-param name="pDia" select="'-1'"/>
            <xsl:with-param name="pMes" select="@mes + 1"/>
            <xsl:with-param name="pAccion" select="'null'"/>
            <xsl:with-param name="pMostrarMeses" select="'null'"/>
            <xsl:with-param name="pDesplazamiento" select="'null'"/>

         </xsl:call-template>
      </xsl:if> 


      
      <xsl:call-template name="CALENDARIOscript">

      </xsl:call-template>

   </xsl:template><xsl:template match="CALENDARIO" mode="body">
      <xsl:if test="@mostrarmeses='3'">
         <DIV ID="{concat(@nombre,'anterior0')}">
            <xsl:text> </xsl:text>
         </DIV>
         <DIV ID="{concat(@nombre,'siguiente0')}">
            <xsl:text> </xsl:text>
         </DIV>
      </xsl:if> 

      <DIV ID="{concat(@nombre,'0')}">
         <xsl:text> </xsl:text>
      </DIV>
   </xsl:template><xsl:template name="CALENDARIOestilo">
      
      <xsl:param name="pNombre" select="@nombre"/>
      <xsl:param name="pX" select="@x"/>
      
      <xsl:text>
</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="$pNombre"/>
      <xsl:text>0 {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="$pX"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;</xsl:text>
      <xsl:text>width:</xsl:text>
      <xsl:value-of select="@ancho"/>
      <xsl:text>;</xsl:text>
      <xsl:text>height:</xsl:text>
      <xsl:value-of select="@alto"/>
      <xsl:text>;visibility:</xsl:text>
      <xsl:choose>
         <xsl:when test="@visibilidad and @visibilidad='visible'">inherit</xsl:when>
         <xsl:otherwise>hidden</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>;clip:rect(0,</xsl:text>
      <xsl:value-of select="@ancho"/><xsl:text>,</xsl:text><xsl:value-of select="@alto"/><xsl:text>,0);</xsl:text> 
      <xsl:text>layer-background-color:</xsl:text><xsl:value-of select="@colorborde"/>
      <xsl:text>;background-color:</xsl:text><xsl:value-of select="@colorborde"/><xsl:text>}
</xsl:text>
   </xsl:template><xsl:template name="CALENDARIOscript">
      
      <xsl:param name="pNombre" select="@nombre"/>
      <xsl:param name="pDia" select="@dia"/>
      <xsl:param name="pMes" select="@mes"/>
      <xsl:param name="pAccion" select="@accion"/>
      <xsl:param name="pMostrarMeses" select="@mostrarmeses"/>
      <xsl:param name="pDesplazamiento" select="@desplazamiento"/>

      <xsl:param name="pMostrarSoloMes">
         <xsl:choose>
           <xsl:when test="@mostrarSoloMes and @mostrarSoloMes='S'">true</xsl:when>
           <xsl:otherwise>false</xsl:otherwise>
         </xsl:choose>
      </xsl:param>




      <xsl:value-of select="$pNombre"/><xsl:text>=new Calendario('</xsl:text>
      <xsl:value-of select="$pNombre"/>
         
      <xsl:text>',</xsl:text>
      <xsl:value-of select="@ancho"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@alto"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@pixelsborde"/><xsl:text>,'</xsl:text>
      <xsl:value-of select="@idmesanio"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@idsemana"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@iddiaoff"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@iddiaon"/><xsl:text>','</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@ruta"/><xsl:text>/','</xsl:text>
      <xsl:value-of select="@fm"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@fM"/><xsl:text>',</xsl:text>
      <xsl:value-of select="$pDia"/><xsl:text>,</xsl:text>
      <xsl:value-of select="$pMes"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@anio"/><xsl:text>,'</xsl:text>
      <xsl:value-of select="$pAccion"/><xsl:text>','</xsl:text>
      <xsl:value-of select="$pDesplazamiento"/><xsl:text>',</xsl:text>

      <xsl:text>[</xsl:text>
      <xsl:for-each select="FESTIVOS/FESTIVO">
         <xsl:text>['</xsl:text><xsl:value-of select="@dia"/><xsl:text>',</xsl:text>
         <xsl:text>'</xsl:text><xsl:value-of select="@mes"/><xsl:text>',</xsl:text>
         <xsl:text>'</xsl:text><xsl:value-of select="@anio"/><xsl:text>',</xsl:text>
         <xsl:text>'</xsl:text><xsl:value-of select="@id"/><xsl:text>']</xsl:text>
         <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>],'</xsl:text>

      <xsl:choose>
        <xsl:when test="@finde and string-length(normalize-space(@finde))&gt;0"><xsl:value-of select="@finde"/></xsl:when>
        <xsl:otherwise><xsl:value-of select="@iddiaoff"/></xsl:otherwise>
      </xsl:choose> 

      <xsl:text>','</xsl:text>
      <xsl:value-of select="$pMostrarMeses"/>
      <xsl:text>',</xsl:text>
      <xsl:value-of select="$pMostrarSoloMes"/>
      <xsl:text>);</xsl:text>
   </xsl:template><xsl:template match="ARBOLLISTA" mode="head">

     
      <SCRIPT>
         <xsl:text>DrdPrecImgsMRut(""</xsl:text>
         <xsl:if test="@imgChk0 and @imgChk0!=''">,"<xsl:value-of select="@imgChk0"/>"</xsl:if>
         <xsl:if test="@imgChk1 and @imgChk1!=''">,"<xsl:value-of select="@imgChk1"/>"</xsl:if>
         <xsl:if test="@imgHueco and @imgHueco!=''">,"<xsl:value-of select="@imgHueco"/>"</xsl:if>
         <xsl:if test="@imgOpen and @imgOpen!=''">,"<xsl:value-of select="@imgOpen"/>"</xsl:if>
         <xsl:if test="@imgClose and @imgClose!=''">,"<xsl:value-of select="@imgClose"/>"</xsl:if>
         <xsl:for-each select="ICONOS/ICONO">
            <xsl:if test="@src and @src!=''">,"<xsl:value-of select="@src"/>"</xsl:if>
         </xsl:for-each>
         <xsl:text>)</xsl:text>
      </SCRIPT>

      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3arbollista.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="ARBOLLISTA" mode="estilo">

      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>

   </xsl:template><xsl:template match="ARBOLLISTA" mode="init">

   </xsl:template><xsl:template match="ARBOLLISTA" mode="script">


      <xsl:variable name="arbolscroll">
         <xsl:value-of select="concat(@nombre,'Scroll')"/>
      </xsl:variable>


      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>=new ArbolLista('</xsl:text>
      <xsl:if test="@imgChk0">
         <xsl:value-of select="$imgPath"/><xsl:value-of select="@imgChk0"/>
      </xsl:if>
      <xsl:text>','</xsl:text>
      <xsl:if test="@imgChk1">
         <xsl:value-of select="$imgPath"/><xsl:value-of select="@imgChk1"/>
      </xsl:if>
      <xsl:text>','</xsl:text>
      <xsl:if test="@imgHueco">
         <xsl:value-of select="$imgPath"/><xsl:value-of select="@imgHueco"/>
      </xsl:if>
      <xsl:text>','</xsl:text>
      <xsl:if test="@imgOpen">
         <xsl:value-of select="$imgPath"/><xsl:value-of select="@imgOpen"/>
      </xsl:if>
      <xsl:text>','</xsl:text>
      <xsl:if test="@imgClose">
         <xsl:value-of select="$imgPath"/><xsl:value-of select="@imgClose"/>
      </xsl:if>
      <xsl:text>',[</xsl:text>

      <xsl:if test="ICONOS">
         <xsl:for-each select="ICONOS/ICONO">
            <xsl:text>'</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@src"/><xsl:text>'</xsl:text>
            <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
         </xsl:for-each>
      </xsl:if>
      <xsl:text>],</xsl:text>
      <xsl:choose>
         <xsl:when test="@pintadoSimplificado and @pintadoSimplificado='S'">true</xsl:when>
         <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose> 

      <xsl:text>,</xsl:text>

      <xsl:choose>
         <xsl:when test="@idNivelesArbol"><xsl:value-of select="@idNivelesArbol"/></xsl:when>
         <xsl:otherwise>[]</xsl:otherwise>
      </xsl:choose>
      
      
      <xsl:text>);</xsl:text>
      




      <xsl:value-of select="@nombre"/><xsl:text>.nombre='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.id=</xsl:text><xsl:value-of select="@id"/><xsl:text>;</xsl:text>
   

	 <xsl:value-of select="@nombre"/><xsl:text>.anchos=</xsl:text><xsl:value-of select="@anchos"/><xsl:text>;</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.checkCascade=</xsl:text><xsl:value-of select="@checkCascade"/><xsl:text>;</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.indent=</xsl:text><xsl:value-of select="@indent"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.TC='ARBOLLISTA';</xsl:text>

	  <xsl:if test="string-length(@accion) &gt; 0">
	     <xsl:value-of select="@nombre"/><xsl:text>.accion="</xsl:text><xsl:value-of select="@accion"/><xsl:text>";</xsl:text>
      </xsl:if> 

     
	  <xsl:if test="string-length(@accionAbrir)&gt;0">
	     <xsl:value-of select="@nombre"/><xsl:text>.accionAbr="</xsl:text><xsl:value-of select="@accionAbrir"/><xsl:text>";</xsl:text>
     </xsl:if> 

	  <xsl:if test="string-length(@seleccionUnica)&gt;0 and @seleccionUnica='N'">
	     <xsl:value-of select="@nombre"/><xsl:text>.seleccionUnica=false;</xsl:text>
      </xsl:if> 

      <xsl:apply-templates mode="script"/>


      



      <xsl:call-template name="SCROLLscript">

         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
      </xsl:call-template>


   </xsl:template><xsl:template match="ICONOS" mode="script">
      
   </xsl:template><xsl:template match="ARBOLLISTA" mode="body">


      
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>Scroll</xsl:text>
         </xsl:variable>

         <xsl:call-template name="SCROLLbody">

            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="@incy"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         </xsl:call-template>
   </xsl:template><xsl:template match="ICONOS" mode="body">
   </xsl:template><xsl:template match="GESTORVENTANAS" mode="head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>gestorventanas.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="GESTORVENTANAS" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="GESTORVENTANAS" mode="init">
	   <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template><xsl:template match="GESTORVENTANAS" mode="script">
	   <xsl:text>var </xsl:text><xsl:value-of select="@nombre"/><xsl:text>=new GestorVentanas("</xsl:text>
			<xsl:value-of select="@nombre"/><xsl:text>","</xsl:text>
      <xsl:choose>
         <xsl:when test="@descriptor">
            <xsl:value-of select="@descriptor"/>
         </xsl:when>
         <xsl:otherwise>
			 <xsl:text>TOP","</xsl:text>
			 <xsl:value-of select="@scroll"/>
			 <xsl:text>","</xsl:text>
			 <xsl:value-of select="@id"/>
			 <xsl:text>",</xsl:text>
			 <xsl:value-of select="@alto"/>
			 <xsl:text>,</xsl:text>
			 <xsl:value-of select="@numeracion"/>
			 <xsl:text>,"</xsl:text>
			 <xsl:value-of select="@pars"/>
         </xsl:otherwise>
      </xsl:choose>
	   <xsl:text>");
	   </xsl:text>

      
        <xsl:text>window.onunload=function(){</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.finit();}</xsl:text>

   </xsl:template><xsl:template match="GESTORVENTANAS" mode="body">
   </xsl:template><xsl:template match="LISTAEDITABLE" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:variable name="vDatosEsc">
            <xsl:text>[</xsl:text>
            <xsl:apply-templates select="ROWSET/ROW" mode="GenDatosConRetCarro"/>
            <xsl:text>]</xsl:text>
         </xsl:variable>
         <xsl:text>
</xsl:text>
         <xsl:text>DrMainEstatico.</xsl:text><xsl:value-of select="@nombre"/>_matrizDatos=<xsl:value-of select="$vDatosEsc"/><xsl:text>;</xsl:text>
         <xsl:text>
</xsl:text>
         <xsl:text>DrMainEstatico.</xsl:text><xsl:value-of select="@nombre"/>.setDatos(DrMainEstatico.<xsl:value-of select="@nombre"/><xsl:text>_matrizDatos);</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="dinamico"/>
   </xsl:template><xsl:template match="LISTAEDITABLE" mode="head">
      
      <xsl:if test="IMGBOTONES">      
         <SCRIPT>
            <xsl:text>DrdPrecImgsMRut(""</xsl:text>
            <xsl:if test="IMGBOTONES/BTNSELECCION/@normal and IMGBOTONES/BTNSELECCION/@normal!=''">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@normal"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNSELECCION/@rollOver and IMGBOTONES/BTNSELECCION/@rollOver!=''">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@rollOver"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNSELECCION/@seleccionado and IMGBOTONES/BTNSELECCION/@seleccionado!=''">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@seleccionado"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNSELECCION/@desactivado and IMGBOTONES/BTNSELECCION/@desactivado!=''">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@desactivado"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimizar and IMGBOTONES/BTNMINIMIZAR/@minimizar!=''">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimizar"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimROver and IMGBOTONES/BTNMINIMIZAR/@minimROver!=''">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimROver"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximizar and IMGBOTONES/BTNMINIMIZAR/@maximizar!=''">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximizar"/>"</xsl:if>
            <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximROver and IMGBOTONES/BTNMINIMIZAR/@maximROver!=''">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximROver"/>"</xsl:if>
            
            <xsl:text>)</xsl:text>
         </SCRIPT>
      </xsl:if>
      <xsl:if test="generate-id(//LISTAEDITABLE[1]) = generate-id()">
         <SCRIPT TYPE="text/javascript">
            <xsl:attribute name="SRC">
               <xsl:value-of select="$jsDruidaPath"/>
               <xsl:text>d3listado.js</xsl:text>
            </xsl:attribute>
            <xsl:text>
</xsl:text>
         </SCRIPT>
      </xsl:if>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="LISTAEDITABLE" mode="estilo">



      <xsl:variable name="incSX"><xsl:choose><xsl:when test="@incScrollx"><xsl:value-of select="@incScrollx"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSY"><xsl:choose><xsl:when test="@incScrolly"><xsl:value-of select="@incScrolly"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="gv"><xsl:choose><xsl:when test="LINEAS/GROSOR/@vertical"><xsl:value-of select="LINEAS/GROSOR/@vertical"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="ghd"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizDatos"><xsl:value-of select="LINEAS/GROSOR/@horizDatos"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="cvd"><xsl:choose><xsl:when test="LINEAS/COLOR/@vertDatos"><xsl:value-of select="LINEAS/COLOR/@vertDatos"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="chd"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizDatos"><xsl:value-of select="LINEAS/COLOR/@horizDatos"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>


      <xsl:variable name="gb"><xsl:choose><xsl:when test="LINEAS/GROSOR/@borde"><xsl:value-of select="LINEAS/GROSOR/@borde"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="ghc">
         <xsl:choose>
            <xsl:when test="CABECERA">
               <xsl:choose>
                  <xsl:when test="LINEAS/GROSOR/@horizCabecera">
                     <xsl:value-of select="LINEAS/GROSOR/@horizCabecera"/>
                  </xsl:when>
                  <xsl:otherwise>2</xsl:otherwise>
               </xsl:choose>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="cb"><xsl:choose><xsl:when test="LINEAS/COLOR/@borde"><xsl:value-of select="LINEAS/COLOR/@borde"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vAltoCab">
         <xsl:choose>
            <xsl:when test="CABECERA/@alto">
               <xsl:value-of select="CABECERA/@alto"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose><xsl:when test="CABECERA">22</xsl:when><xsl:otherwise>0</xsl:otherwise></xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="colorFondo"><xsl:choose><xsl:when test="@colorFondo"><xsl:value-of select="@colorFondo"/></xsl:when><xsl:otherwise>white</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vAltoTitulo">
         <xsl:choose>
            <xsl:when test="TITULO"><xsl:choose><xsl:when test="TITULO/@alto"><xsl:value-of select="TITULO/@alto"/></xsl:when><xsl:otherwise>22</xsl:otherwise></xsl:choose></xsl:when> 
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vGrHTitulo">
         <xsl:choose>
            <xsl:when test="TITULO"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizTitulo"><xsl:value-of select="LINEAS/GROSOR/@horizTitulo"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:when> 
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vReservadoTitulo"><xsl:value-of select="$vAltoTitulo + $vGrHTitulo"/></xsl:variable>


      <xsl:variable name="vAltoBase">
         <xsl:choose>
            <xsl:when test="BASE"><xsl:choose><xsl:when test="BASE/@alto"><xsl:value-of select="BASE/@alto"/></xsl:when><xsl:otherwise>22</xsl:otherwise></xsl:choose></xsl:when> 
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vGrHBase">
         <xsl:choose>
            <xsl:when test="BASE"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizBase"><xsl:value-of select="LINEAS/GROSOR/@horizBase"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vReservadoBase"><xsl:value-of select="$vAltoBase + $vGrHBase"/></xsl:variable>

      
      
      <xsl:text>
#Cp</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/>; background-color: <xsl:value-of select="$colorFondo"/>; layer-background-color: <xsl:value-of select="$colorFondo"/>; <xsl:text>}
</xsl:text>

      
      <xsl:text>#CpCab</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho - (2 * $gb)"/>; height:<xsl:value-of select="$gb + $ghc + $vAltoCab"/>; left: <xsl:value-of select="$gb"/>; top: <xsl:value-of select="$gb + $vReservadoTitulo"/>; <xsl:text>;}
</xsl:text>  
      

      
      <xsl:if test="CABECERA/@imgFondo or CABECERA/@colFondo">
         <xsl:variable name="imgfond"><xsl:if test="CABECERA/@imgFondo"> background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="CABECERA/@imgFondo"/>);layer-background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="CABECERA/@imgFondo"/>);</xsl:if></xsl:variable>
         <xsl:variable name="colfond"><xsl:if test="CABECERA/@colFondo"> layer-background-color: <xsl:value-of select="CABECERA/@colFondo"/>; background-color: <xsl:value-of select="CABECERA/@colFondo"/> ;</xsl:if></xsl:variable>
         <xsl:text>#CpFCab</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$vAltoCab + $ghc"/>; left: 0; top: <xsl:value-of select="$gb+$vReservadoTitulo"/>; <xsl:value-of select="$imgfond"/> <xsl:value-of select="$colfond"/> <xsl:text>;}</xsl:text>
      </xsl:if>

      <xsl:variable name="cColScr"><xsl:if test="DATOS/@coloresScrollNativo"><xsl:value-of select="DATOS/@coloresScrollNativo"/></xsl:if></xsl:variable>

      <xsl:if test="CABECERA and $ghc &gt; 0"> 
         <xsl:variable name="chc"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizCabecera"><xsl:value-of select="LINEAS/COLOR/@horizCabecera"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
         <xsl:text>#CpLCab</xsl:text><xsl:value-of select="@nombre"/> {border: <xsl:value-of select="$ghc"/>px solid <xsl:value-of select="$chc"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$ghc"/>; left: 0; top: <xsl:value-of select="$gb + $vAltoCab + $vReservadoTitulo"/><xsl:text>; overflow: hidden;}
</xsl:text>   
      </xsl:if>

      
      <xsl:if test="TITULO">
         <xsl:variable name="imgfondTit"><xsl:if test="TITULO/@imgFondo"> background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="TITULO/@imgFondo"/>);layer-background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="TITULO/@imgFondo"/>);</xsl:if></xsl:variable>
         <xsl:variable name="colfondTit"><xsl:if test="TITULO/@colFondo"> layer-background-color: <xsl:value-of select="TITULO/@colFondo"/>; background-color: <xsl:value-of select="TITULO/@colFondo"/> ;</xsl:if></xsl:variable>

         <xsl:text>#CpTit</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:100%; height:<xsl:value-of select="$vAltoTitulo"/>; left:0; top: <xsl:value-of select="$gb "/>; <xsl:value-of select="$imgfondTit"/><xsl:value-of select="$colfondTit"/><xsl:text>;}
</xsl:text>
         <xsl:if test="not($vGrHTitulo='0')">
            <xsl:variable name="cht"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizTitulo"><xsl:value-of select="LINEAS/COLOR/@horizTitulo"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
            
            <xsl:text>#CpLTit</xsl:text><xsl:value-of select="@nombre"/>{border: <xsl:value-of select="$vGrHTitulo"/>px solid <xsl:value-of select="$cht"/>;position:absolute; width:100%; height:<xsl:value-of select="$vGrHTitulo"/>; left: 0; top: <xsl:value-of select="$gb + $vAltoTitulo"/><xsl:text>; overflow: hidden;}
</xsl:text>
         </xsl:if>
      </xsl:if>

      
      <xsl:if test="BASE">
         <xsl:variable name="imgfondBas"><xsl:if test="BASE/@imgFondo"> background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="BASE/@imgFondo"/>);layer-background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="BASE/@imgFondo"/>);</xsl:if></xsl:variable>
         <xsl:variable name="colfondBas"><xsl:if test="BASE/@colFondo"> layer-background-color: <xsl:value-of select="BASE/@colFondo"/>; background-color: <xsl:value-of select="BASE/@colFondo"/> ;</xsl:if></xsl:variable>
         <xsl:text>#CpBas</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:100%; height:<xsl:value-of select="$vAltoBase"/>; left:0; top: <xsl:value-of select="@alto -$vAltoBase -$gb"/>; <xsl:value-of select="$imgfondBas"/><xsl:value-of select="$colfondBas"/><xsl:text>;}
</xsl:text>
         <xsl:if test="not($vGrHBase='0')">
            <xsl:variable name="chb"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizBase"><xsl:value-of select="LINEAS/COLOR/@horizBase"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
            <xsl:text>#CpLBas</xsl:text><xsl:value-of select="@nombre"/>{border: <xsl:value-of select="$vGrHBase"/>px solid <xsl:value-of select="$chb"/>;position:absolute; width:100%; height:<xsl:value-of select="$vGrHBase"/>; left: 0; top: <xsl:value-of select="@alto -$vReservadoBase -$gb"/><xsl:text>; overflow: hidden;}
</xsl:text>
         </xsl:if>
      </xsl:if>

      
      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre">CpScroll<xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$gb"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vAltoCab + $ghc + $gb + $vReservadoTitulo"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$incSX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$incSY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho - ($gb * 2) -16"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto - $vAltoCab - ($gb * 2) -16 - $ghc -$vReservadoTitulo -$vReservadoBase"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="$colorFondo"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colores"><xsl:value-of select="$cColScr"/></xsl:with-param>
      </xsl:call-template>

      

      <xsl:text>#CpLin1</xsl:text><xsl:value-of select="@nombre"/> {border: <xsl:value-of select="$gb"/>px solid <xsl:value-of select="$cb"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$gb"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/><xsl:text>; overflow: hidden;}
</xsl:text>
      <xsl:text>#CpLin3</xsl:text><xsl:value-of select="@nombre"/> {border: <xsl:value-of select="$gb"/>px solid <xsl:value-of select="$cb"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$gb"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@alto +@y - $gb"/><xsl:text>; overflow: hidden;}
</xsl:text>
      <xsl:text>#CpLin2</xsl:text><xsl:value-of select="@nombre"/> {position:absolute; width:<xsl:value-of select="$gb"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/>; overflow: hidden;background-color:<xsl:value-of select="$cb"/>;layer-background-color:<xsl:value-of select="$cb"/>;clip:rect(0,<xsl:value-of select="$gb"/>,<xsl:value-of select="@alto"/><xsl:text>,0);}
</xsl:text>
      <xsl:text>#CpLin4</xsl:text><xsl:value-of select="@nombre"/> {position:absolute; width:<xsl:value-of select="$gb"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x + @ancho - $gb"/>; top: <xsl:value-of select="@y"/>; overflow: hidden;background-color:<xsl:value-of select="$cb"/>;layer-background-color:<xsl:value-of select="$cb"/>;clip:rect(0,<xsl:value-of select="$gb"/>,<xsl:value-of select="@alto"/><xsl:text>,0);}
</xsl:text>

      <xsl:if test="$vgPintadoSimplificado='S' or (@pintadoSimplificado and @pintadoSimplificado='S' and not($gv='0' and $ghd='0'))">
         <xsl:text>.brdTblDat</xsl:text><xsl:value-of select="@nombre"/><xsl:text> td {</xsl:text>
         <xsl:if test="$gv!='0'">
            <xsl:text>border-right:</xsl:text><xsl:value-of select="$gv"/>px solid <xsl:value-of select="$cvd"/><xsl:text>;</xsl:text>
         </xsl:if>
         <xsl:if test="$ghd!='0'">
            <xsl:text>border-bottom:</xsl:text><xsl:value-of select="$ghd"/>px solid <xsl:value-of select="$chd"/>
         </xsl:if>
         <xsl:text>}
</xsl:text>
      </xsl:if>

      <xsl:apply-templates mode="estilo">

      </xsl:apply-templates>

   </xsl:template><xsl:template match="LISTAEDITABLE" mode="script">
      

      
      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:if test="$frmNombre!=''">
         <xsl:variable name="nombrFinal" select="concat($frmNombre,'.',@nombre)"/>         
         <xsl:value-of select="$nombrFinal"/><xsl:text>TC='Listado';</xsl:text>

         <xsl:value-of select="$nombrFinal"/><xsl:text>IE='';</xsl:text>
         <xsl:value-of select="$nombrFinal"/>OBJ='<xsl:value-of select="@nombre"/><xsl:text>';</xsl:text>
      </xsl:if>

     
      <xsl:variable name="gb"><xsl:choose><xsl:when test="LINEAS/GROSOR/@borde"><xsl:value-of select="LINEAS/GROSOR/@borde"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="gv"><xsl:choose><xsl:when test="LINEAS/GROSOR/@vertical"><xsl:value-of select="LINEAS/GROSOR/@vertical"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="ghd"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizDatos"><xsl:value-of select="LINEAS/GROSOR/@horizDatos"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
      
      <xsl:variable name="ghc">
         <xsl:choose>
            <xsl:when test="CABECERA">
               <xsl:choose>
                  <xsl:when test="LINEAS/GROSOR/@horizCabecera">
                     <xsl:value-of select="LINEAS/GROSOR/@horizCabecera"/>
                  </xsl:when>
                  <xsl:otherwise>2</xsl:otherwise>
               </xsl:choose>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vAltoCabLEs">
         <xsl:choose>
            <xsl:when test="CABECERA/@alto">
               <xsl:value-of select="CABECERA/@alto"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="CABECERA">22</xsl:when>
                  <xsl:otherwise>0</xsl:otherwise>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="cb"><xsl:choose><xsl:when test="LINEAS/COLOR/@borde"><xsl:value-of select="LINEAS/COLOR/@borde"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="cvd"><xsl:choose><xsl:when test="LINEAS/COLOR/@vertDatos"><xsl:value-of select="LINEAS/COLOR/@vertDatos"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="cvc"><xsl:choose><xsl:when test="LINEAS/COLOR/@vertCabecera"><xsl:value-of select="LINEAS/COLOR/@vertCabecera"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="chd"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizDatos"><xsl:value-of select="LINEAS/COLOR/@horizDatos"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="chc"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizCabecera"><xsl:value-of select="LINEAS/COLOR/@horizCabecera"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSX"><xsl:choose><xsl:when test="@incScrollx"><xsl:value-of select="@incScrollx"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSY"><xsl:choose><xsl:when test="@incScrolly"><xsl:value-of select="@incScrolly"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      
      <xsl:variable name="capcabdoc" select="concat('Cp',@nombre,'.document.CpCab',@nombre,'.document')"/>
      <xsl:call-template name="CAPAscript">

         <xsl:with-param name="nombre"><xsl:value-of select="concat('CpCab',@nombre)"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>

      <xsl:variable name="capadiv">
         <xsl:value-of select="concat('Cp',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="listascroll">
         <xsl:value-of select="concat('CpScroll',@nombre)"/>
      </xsl:variable>

      
      <xsl:call-template name="SCROLLscript">

         <xsl:with-param name="nombre">CpScroll<xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$gb"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vAltoCabLEs + ($gb * 2)"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$incSX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$incSY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho - ($gb * 2) -16"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto - $vAltoCabLEs - ($gb * 3) - 16"/></xsl:with-param>
      </xsl:call-template>

      <xsl:text> if (!CpCab</xsl:text><xsl:value-of select="@nombre"/>) CpCab<xsl:value-of select="@nombre"/><xsl:text>=new Object();</xsl:text>
      
      
      <xsl:variable name="vAccion">
         <xsl:if test="DATOS/@accion">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@accion"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vAnchos">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GeneraAnchos"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vTiposCol">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="DATOS/COL" mode="GenTipCol"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vTiposAnchos">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GenTipAnchos"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vColMinimiz">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GenMinimiz"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      
      <xsl:variable name="vDatos2">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="ROWSET/ROW" mode="GenDatosConRetCarro"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vOrdenesCol">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GenOrdCol"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vTxtCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">    
            <xsl:text>'</xsl:text>
            <xsl:choose>
               <xsl:when test="@cod">
                  <xsl:call-template name="langtxt">
                     <xsl:with-param name="pCod" select="@cod"/>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate(., '&#xA;',' ')"/>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:otherwise>
            </xsl:choose>
            <xsl:text>',</xsl:text>
         </xsl:for-each>
         <xsl:text>'']</xsl:text>
      </xsl:variable>


      <xsl:variable name="vEstilosCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">    
            <xsl:text>"</xsl:text>
               <xsl:if test="@ID">
                  <xsl:value-of select="@ID"/>
               </xsl:if>
            <xsl:text>",</xsl:text>
         </xsl:for-each>
         <xsl:text>""]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vTooltipsCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">    
            <xsl:text>'</xsl:text>
               <xsl:if test="@toolTip">
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate(@toolTip, '&#xA;',' ')"/>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:if>
            <xsl:text>',</xsl:text>
         </xsl:for-each>
         <xsl:text>'']</xsl:text>
      </xsl:variable>

      <xsl:variable name="vEstilosDat">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="DATOS/COL" mode="GenEstDat"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vColoresCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">
            <xsl:text>"</xsl:text>
               <xsl:if test="@colFondo">
                  <xsl:value-of select="@colFondo"/>
               </xsl:if>
            <xsl:text>",</xsl:text>
         </xsl:for-each>      
         <xsl:text>""]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vGruposCab">
         <xsl:text>[</xsl:text>

         <xsl:for-each select="CABECERA/COL | CABECERA/GRUPO">
            <xsl:if test="name() = 'COL'">null</xsl:if>
            <xsl:if test="name() = 'GRUPO'">
               <xsl:text>[</xsl:text>
               <xsl:value-of select="count(COL)"/>
               <xsl:text>,'</xsl:text>
               <xsl:choose>
                  <xsl:when test="@cod">
                     <xsl:call-template name="langtxt">
                        <xsl:with-param name="pCod" select="@cod"/>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:when test="@txt">
                     <xsl:call-template name="escapa">
                        <xsl:with-param name="text" select="translate(@txt, '&#xA;',' ')"/>
                        <xsl:with-param name="caracter">'</xsl:with-param>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:otherwise/>
               </xsl:choose>
               <xsl:text>',"</xsl:text>
               <xsl:if test="@ID">
                  <xsl:value-of select="@ID"/>
               </xsl:if>
               <xsl:text>","</xsl:text>
               <xsl:if test="@colFondo">
                  <xsl:value-of select="@colFondo"/>
               </xsl:if>
               <xsl:text>"]</xsl:text>
               <xsl:for-each select="COL">
                  <xsl:if test="not(position() = last())">,[]</xsl:if>
               </xsl:for-each>
            </xsl:if>
            <xsl:if test="not(position() = last())">,</xsl:if>
         </xsl:for-each>   
         
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vColFonScr">
         <xsl:if test="CABECERA/@colFondoScroll">
            <xsl:value-of select="CABECERA/@colFondoScroll"/>
         </xsl:if>
      </xsl:variable>

      <xsl:variable name="vAltoDat">
         <xsl:choose>
            <xsl:when test="DATOS/@alto">
               <xsl:value-of select="DATOS/@alto"/>
            </xsl:when>
            <xsl:otherwise>22</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>       
      <xsl:variable name="vAnchoColMinim"><xsl:choose><xsl:when test="COLUMNAS/@anchoMinimizadas"><xsl:value-of select="COLUMNAS/@anchoMinimizadas"/></xsl:when><xsl:otherwise>9</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vNumNbsp"><xsl:choose><xsl:when test="COLUMNAS/@blancosAInsertar"><xsl:value-of select="COLUMNAS/@blancosAInsertar"/></xsl:when><xsl:otherwise>0</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vAjusteMin"><xsl:choose><xsl:when test="COLUMNAS/@ajustarMinimo and COLUMNAS/@ajustarMinimo='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vNoWrap"><xsl:choose><xsl:when test="COLUMNAS/@sinSaltoLinea and COLUMNAS/@sinSaltoLinea='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vBtnOff"><xsl:if test="IMGBOTONES/BTNSELECCION/@normal"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@normal"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnOn"><xsl:if test="IMGBOTONES/BTNSELECCION/@rollOver"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@rollOver"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnSel"><xsl:if test="IMGBOTONES/BTNSELECCION/@seleccionado"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@seleccionado"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnDesac"><xsl:if test="IMGBOTONES/BTNSELECCION/@desactivado"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@desactivado"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMinN"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimizar"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimizar"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMinS"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimROver"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimROver"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMaxN"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximizar"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximizar"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMaxS"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximROver"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximROver"/></xsl:if></xsl:variable>
      <xsl:variable name="vConRoll"><xsl:choose><xsl:when test="IMGBOTONES/@conROver and IMGBOTONES/@conROver='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vBtnOrd"><xsl:if test="IMGBOTONES/BTNORDENAR/@ordenar"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNORDENAR/@ordenar"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnOrdInv"><xsl:if test="IMGBOTONES/BTNORDENAR/@ordenarInv"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNORDENAR/@ordenarInv"/></xsl:if></xsl:variable>
      <xsl:variable name="vMaxSel"><xsl:choose><xsl:when test="DATOS/@maxSel"><xsl:value-of select="DATOS/@maxSel"/></xsl:when><xsl:otherwise>-1</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vOnSetDatos">
         <xsl:if test="DATOS/@onSetDatos">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@onSetDatos"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vOnAfterSetDatos">
         <xsl:if test="DATOS/@onAfterSetDatos">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@onAfterSetDatos"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vOnLoad">
         <xsl:if test="DATOS/@onLoad">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@onLoad"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vOrdCol"><xsl:choose><xsl:when test="not(COLUMNAS/@permiteOrdenar)">true</xsl:when><xsl:when test="COLUMNAS/@permiteOrdenar='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vFondCab"><xsl:choose><xsl:when test="CABECERA/@imgFondo"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="CABECERA/@imgFondo"/></xsl:when><xsl:otherwise/></xsl:choose></xsl:variable>
      <xsl:variable name="vTxtMinim"><xsl:choose><xsl:when test="CABECERA/@txtEnMinimizadas and CABECERA/@txtEnMinimizadas='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vMsgDebugJS"><xsl:choose><xsl:when test="@msgDebugJS and @msgDebugJS='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vTipEnvio"><xsl:choose><xsl:when test="DATOS/@tipoEnvio"><xsl:value-of select="DATOS/@tipoEnvio"/></xsl:when><xsl:otherwise>seleccion</xsl:otherwise></xsl:choose></xsl:variable>
      
      <xsl:variable name="vRepntCab"><xsl:choose><xsl:when test="CABECERA">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vFormaEnv"><xsl:choose><xsl:when test="DATOS/@formaEnvio"><xsl:value-of select="DATOS/@formaEnvio"/></xsl:when><xsl:otherwise>serializado</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vDeseleccSiMax"><xsl:choose><xsl:when test="DATOS/@deseleccionaSiMaxSel and DATOS/@deseleccionaSiMaxSel='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vAjustarAMitadInf"><xsl:choose><xsl:when test="CABECERA/@ajustarAMitadInf and CABECERA/@ajustarAMitadInf='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vHayBotonOrdenar"><xsl:choose><xsl:when test="COLUMNAS/@botonOrdenar and COLUMNAS/@botonOrdenar='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vHayTitulo"><xsl:choose><xsl:when test="TITULO and not(TITULO/@alto='0')">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vNombrePaginado"><xsl:choose><xsl:when test="PAGINADO and PAGINADO/@nombre"><xsl:value-of select="PAGINADO/@nombre"/></xsl:when><xsl:otherwise/></xsl:choose></xsl:variable>

      <xsl:variable name="vDatosTitulo">
         <xsl:text>[</xsl:text>
         <xsl:if test="TITULO">
            <xsl:text>'</xsl:text>
            <xsl:choose>
               <xsl:when test="TITULO/@cod">
                  <xsl:call-template name="escapaCaracterYBarra">
                     <xsl:with-param name="text"><xsl:call-template name="langtxt"><xsl:with-param name="pCod" select="TITULO/@cod"/></xsl:call-template></xsl:with-param>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="TITULO"/><xsl:with-param name="caracter">'</xsl:with-param></xsl:call-template>
               </xsl:otherwise>
            </xsl:choose>
            <xsl:text>',</xsl:text>
            <xsl:choose><xsl:when test="TITULO/@ID">'<xsl:value-of select="TITULO/@ID"/>'</xsl:when><xsl:otherwise>''</xsl:otherwise></xsl:choose>
            <xsl:text>,</xsl:text>
            <xsl:choose><xsl:when test="TITULO/@alto"><xsl:value-of select="TITULO/@alto"/></xsl:when><xsl:otherwise>22</xsl:otherwise></xsl:choose>
         </xsl:if>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vTipoSeleccion"><xsl:choose><xsl:when test="DATOS/@tipoSeleccion">"<xsl:value-of select="DATOS/@tipoSeleccion"/>"</xsl:when><xsl:otherwise>"fila"</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vScrollAsociado"><xsl:choose><xsl:when test="DATOS/@scrollAsociado">"<xsl:value-of select="DATOS/@scrollAsociado"/>"</xsl:when><xsl:otherwise>""</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vBarraScroll"><xsl:choose><xsl:when test="DATOS/@barraScroll">"<xsl:value-of select="DATOS/@barraScroll"/>"</xsl:when><xsl:otherwise>""</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vPrimerRefresco"><xsl:choose><xsl:when test="DATOS/@primerRefresco and DATOS/@primerRefresco='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vAccionDobleClick">
         <xsl:text>"</xsl:text>
         <xsl:if test="DATOS/@accionDobleClick">
            <xsl:call-template name="escapaCaracterYBarra">
                <xsl:with-param name="text" select="DATOS/@accionDobleClick"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
         <xsl:text>"</xsl:text>
      </xsl:variable>
      <xsl:variable name="vMsegDobleClick">
         <xsl:choose>
            <xsl:when test="DATOS/@msegDobleClick"><xsl:value-of select="DATOS/@msegDobleClick"/></xsl:when>
            <xsl:otherwise>200</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vAutoScroll">
         <xsl:choose>
            <xsl:when test="@autoScroll and @autoScroll='S'">true</xsl:when>
            <xsl:otherwise>false</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vOnClickColumna">
         <xsl:choose>
            <xsl:when test="CABECERA/@onClick">
               <xsl:text>"</xsl:text>
               <xsl:call-template name="escapaCaracterYBarra">
                   <xsl:with-param name="text" select="CABECERA/@onClick"/>
                   <xsl:with-param name="caracter">"</xsl:with-param>
               </xsl:call-template>
               <xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vPintadoRapido">
         <xsl:choose>
            
            <xsl:when test="@pintadoSimplificado and @pintadoSimplificado='S'">true</xsl:when>
            <xsl:when test="not(@pintadoSimplificado) and $vgPintadoSimplificado='S'">true</xsl:when>
            <xsl:otherwise>false</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      
      <xsl:text>
</xsl:text><xsl:value-of select="@nombre"/>_matrizDatos=<xsl:value-of select="$vDatos2"/><xsl:text>;</xsl:text>
      
      <xsl:text>
</xsl:text><xsl:value-of select="@nombre"/>=new TListado('<xsl:value-of select="@nombre"/>',<xsl:value-of select="@ancho"/>,<xsl:value-of select="@alto"/>,<xsl:value-of select="$gb"/>,<xsl:value-of select="$ghc"/>,<xsl:value-of select="$ghd"/>,<xsl:value-of select="$gv"/>
      <xsl:text>,'</xsl:text><xsl:value-of select="$chd"/>','<xsl:value-of select="$cvd"/>','<xsl:value-of select="$cvc"/>',"<xsl:value-of select="$vAccion"/>",<xsl:value-of select="$vAnchos"/>,<xsl:value-of select="$vTiposAnchos"/>,<xsl:value-of select="$vColMinimiz"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vAltoDat"/>,<xsl:value-of select="$vAltoCabLEs"/>,<xsl:value-of select="$vAnchoColMinim"/>,<xsl:value-of select="@nombre"/><xsl:text>_matrizDatos</xsl:text>
      <xsl:text>,</xsl:text><xsl:value-of select="$vTiposCol"/>,<xsl:value-of select="$vOrdenesCol"/>,<xsl:value-of select="$vTxtCab"/>,<xsl:value-of select="$vEstilosCab"/>,<xsl:value-of select="$vColoresCab"/>,<xsl:value-of select="$vEstilosDat"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vNumNbsp"/>,<xsl:value-of select="$vAjusteMin"/>,<xsl:value-of select="$vNoWrap"/>
      <xsl:text>,"</xsl:text><xsl:value-of select="$vBtnOff"/>","<xsl:value-of select="$vBtnOn"/>","<xsl:value-of select="$vBtnSel"/>","<xsl:value-of select="$vBtnDesac"/>
      <xsl:text>","</xsl:text><xsl:value-of select="$vBtnMinN"/>","<xsl:value-of select="$vBtnMinS"/>","<xsl:value-of select="$vBtnMaxN"/>","<xsl:value-of select="$vBtnMaxS"/>
      <xsl:text>",</xsl:text><xsl:value-of select="$vConRoll"/>,"<xsl:value-of select="$vFondCab"/>",'',<xsl:value-of select="$vMaxSel"/>,"<xsl:if test="@msgErrMaxSel"><xsl:value-of select="@msgErrMaxSel"/></xsl:if>","<xsl:if test="DATOS/@colorROver"><xsl:value-of select="DATOS/@colorROver"/></xsl:if>","<xsl:if test="DATOS/@colorSelecc"><xsl:value-of select="DATOS/@colorSelecc"/></xsl:if>
      <xsl:text>",</xsl:text><xsl:value-of select="$vOrdCol"/>,"<xsl:value-of select="$vOnSetDatos"/>","try{evalua_ultima(this.nombrePaginado, datos);}catch(e){} <xsl:value-of select="$vOnAfterSetDatos"/>",<xsl:value-of select="$vTxtMinim"/>,<xsl:value-of select="$vMsgDebugJS"/>,"<xsl:value-of select="$vTipEnvio"/>","<xsl:value-of select="$vFormaEnv"/>","<xsl:value-of select="$vOnLoad"/>",<xsl:value-of select="$vRepntCab"/>,"<xsl:value-of select="$vColFonScr"/>",<xsl:value-of select="$vGruposCab"/>,<xsl:value-of select="$vDeseleccSiMax"/>,<xsl:value-of select="$vAjustarAMitadInf"/>
      <xsl:text>,"</xsl:text><xsl:value-of select="$vBtnOrd"/>","<xsl:value-of select="$vBtnOrdInv"/>",<xsl:value-of select="$vHayBotonOrdenar"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vHayTitulo"/>,<xsl:value-of select="$vDatosTitulo"/>,"<xsl:value-of select="$vNombrePaginado"/>",<xsl:value-of select="$vTipoSeleccion"/>,<xsl:value-of select="$vScrollAsociado"/>,<xsl:value-of select="$vBarraScroll"/>,<xsl:value-of select="$vPrimerRefresco"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vAccionDobleClick"/>,<xsl:value-of select="$vMsegDobleClick"/>,<xsl:value-of select="$vAutoScroll"/>,<xsl:value-of select="$vOnClickColumna"/>,<xsl:value-of select="$vPintadoRapido"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vTooltipsCab"/>
      <xsl:text>);</xsl:text>

      
      
      

      <xsl:apply-templates mode="script">

      </xsl:apply-templates>
      
   </xsl:template><xsl:template match="COLUMNAS/COL" mode="GeneraAnchos">
      <xsl:choose>
         <xsl:when test="not(@ancho)">1</xsl:when>
         <xsl:otherwise><xsl:value-of select="@ancho"/></xsl:otherwise>
      </xsl:choose>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="DATOS/COL" mode="GenTipCol">
      <xsl:text>[</xsl:text>
      <xsl:variable name="posic" select="position()"/>
      <xsl:variable name="col" select="../../COLUMNAS/COL[position()=$posic]"/>
      <xsl:if test="$col/@oculta and $col/@oculta='S'">"OCULTA",</xsl:if>
      <xsl:if test="$col/@minimizada and $col/@minimizada='S'">"MINIMIZADA",</xsl:if>
      <xsl:if test="@tipo">
         <xsl:choose>
            <xsl:when test="@tipo='boton'">"BOTON"</xsl:when>
            <xsl:when test="@tipo='cajatexto'">
               <xsl:variable name="vValid">
                  <xsl:if test="@validacion"><xsl:call-template name="escapa"><xsl:with-param name="text" select="@validacion"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if>
               </xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vOnchange">
                  <xsl:choose>
                     <xsl:when test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:when>
                     <xsl:when test="@onChange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onChange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:when>
                     <xsl:otherwise/>
                  </xsl:choose>
               </xsl:variable>
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnBlur"><xsl:if test="@onBlur"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onBlur"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vDeshab"><xsl:choose><xsl:when test="@deshabilitado and @deshabilitado='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vOnKeyDown"><xsl:if test="@onKeyDown"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onKeyDown"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnFocus"><xsl:if test="@onFocus"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onFocus"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:text>"CAJATEXTO","</xsl:text><xsl:value-of select="@nombre"/>",<xsl:value-of select="@size"/>,<xsl:value-of select="@max"/>,"<xsl:value-of select="@IDOBJ"/>","<xsl:value-of select="$vValid"/>","<xsl:value-of select="$vReq"/>","<xsl:value-of select="$vOnchange"/>",<xsl:value-of select="$vDeshab"/>,"<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/>","<xsl:value-of select="$vOnBlur"/>","<xsl:value-of select="$vOnKeyDown"/>","<xsl:value-of select="$vOnFocus"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='areatexto'">
               <xsl:variable name="vValid">
                  <xsl:if test="@validacion"><xsl:call-template name="escapa"><xsl:with-param name="text" select="@validacion"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if>
               </xsl:variable>
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vCols"><xsl:if test="@cols"><xsl:value-of select="@cols"/></xsl:if></xsl:variable>
               <xsl:variable name="vRows"><xsl:if test="@rows"><xsl:value-of select="@rows"/></xsl:if></xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:text>"AREATEXTO","</xsl:text><xsl:value-of select="@nombre"/>",<xsl:value-of select="$vRows"/>,<xsl:value-of select="$vCols"/>,"<xsl:value-of select="@IDOBJ"/>","<xsl:value-of select="$vValid"/>","<xsl:value-of select="$vReq"/>","<xsl:value-of select="$vOnchange"/>","<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='checkbox'">
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vDeshab"><xsl:choose><xsl:when test="@deshabilitado and @deshabilitado='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:text>"CHECKBOX","</xsl:text><xsl:value-of select="@nombre"/>","N","<xsl:value-of select="$vOnchange"/>","<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/>",<xsl:value-of select="$vDeshab"/>
            </xsl:when>
            <xsl:when test="@tipo='combo'">
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vMult"><xsl:choose><xsl:when test="@multiple and @multiple='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vSiz"><xsl:choose><xsl:when test="@size"><xsl:value-of select="@size"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vDeshab"><xsl:choose><xsl:when test="@deshabilitado and @deshabilitado='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:text>"COMBO","</xsl:text><xsl:value-of select="@nombre"/>",[<xsl:apply-templates select="ROWSET/ROW" mode="GenDatCombo"/>],"<xsl:value-of select="@IDOBJ"/>","<xsl:value-of select="$vReq"/>",<xsl:value-of select="$vMult"/>,<xsl:value-of select="$vSiz"/>,"<xsl:value-of select="$vOnchange"/>",<xsl:value-of select="$vDeshab"/>,"<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='imagen'">
               <xsl:text>"IMAGEN"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='radiobutton'">
               <xsl:variable name="vOnclick"><xsl:if test="@onclick"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onclick"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="rbinputs">
                  <xsl:text>[</xsl:text>
                  <xsl:for-each select="RBINPUT">
                     <xsl:text>["</xsl:text>
                     <xsl:call-template name="escapa"><xsl:with-param name="text" select="@valor"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template>
                     <xsl:text>","</xsl:text>
                     <xsl:choose>
                        <xsl:when test="@cod">
                           <xsl:call-template name="escapa">
                              <xsl:with-param name="text">
                                 <xsl:call-template name="langtxt">
                                    <xsl:with-param name="pCod" select="@cod"/>
                                 </xsl:call-template>
                              </xsl:with-param>
                              <xsl:with-param name="caracter">"</xsl:with-param>
                           </xsl:call-template>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:call-template name="escapa"><xsl:with-param name="text" select="."/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template>
                        </xsl:otherwise>
                     </xsl:choose>
                     <xsl:text>"]</xsl:text>
                     <xsl:if test="not(position()=last())">,</xsl:if>
                  </xsl:for-each>
                  <xsl:text>]</xsl:text>
               </xsl:variable>
               <xsl:text>"RADIOBUTTON","</xsl:text><xsl:value-of select="@nombre"/>",<xsl:value-of select="$rbinputs"/>,"<xsl:value-of select="$vReq"/>","<xsl:value-of select="$vOnclick"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='botonytexto'"> 
               <xsl:text>"BOTONYTEXTO"</xsl:text>
            </xsl:when>
            <xsl:otherwise>"TEXTO"</xsl:otherwise>
         </xsl:choose>
      </xsl:if>
      <xsl:if test="not(@tipo)">"TEXTO"</xsl:if>
      <xsl:text>]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="ROWSET/ROW" mode="GenDatCombo">
      <xsl:variable name="cod" select="concat(CAMPO[1]/@VALOR,CAMPO[1])"/>
      <xsl:variable name="desc" select="concat(CAMPO[2]/@VALOR,CAMPO[2])"/>
      <xsl:text>["</xsl:text>
      <xsl:value-of select="$cod"/>","<xsl:value-of select="$desc"/>
      <xsl:text>"]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="COLUMNAS/COL" mode="GenTipAnchos">
      <xsl:text>"</xsl:text>
      <xsl:if test="@tipoAncho and @tipoAncho='fijo'">F</xsl:if>
      <xsl:text>"</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="COLUMNAS/COL" mode="GenMinimiz">
      <xsl:if test="@minimizable and @minimizable='S'">1</xsl:if>
      <xsl:if test="not(@minimizable and @minimizable='S')">0</xsl:if>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="ROWSET/ROW" mode="GenDatos">
      <xsl:text>[</xsl:text>
      <xsl:apply-templates select="CAMPO" mode="GenDatos"/>
      <xsl:text>]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="ROWSET/ROW" mode="GenDatosConRetCarro">
      <xsl:text>[</xsl:text>
      <xsl:apply-templates select="CAMPO" mode="GenDatos"/>
      <xsl:text>]</xsl:text>
      <xsl:if test="not(position()=last())">,
</xsl:if>
   </xsl:template><xsl:template match="CAMPO" mode="GenDatos">
      <xsl:text>"</xsl:text>
      <xsl:call-template name="escapaCaracterYBarra">
          <xsl:with-param name="text" select="concat(@VALOR,.)"/>
          <xsl:with-param name="caracter">"</xsl:with-param>
      </xsl:call-template>
      <xsl:text>"</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="COLUMNAS/COL" mode="GenOrdCol">
      
      <xsl:choose>
         <xsl:when test="not(@orden)">0</xsl:when>
         <xsl:when test="@orden='numerico'">1</xsl:when>
         <xsl:when test="@orden='dd-mm-aaaa'">2</xsl:when>
         <xsl:when test="@orden='comaDecimalFormateado'">3</xsl:when>
         <xsl:when test="@orden='dd-mm-aa'">4</xsl:when>
         <xsl:otherwise>0</xsl:otherwise>
      </xsl:choose>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="DATOS/COL" mode="GenEstDat">
      <xsl:text>["</xsl:text>
         <xsl:if test="@ID">
            <xsl:value-of select="@ID"/>
         </xsl:if>
      <xsl:text>"]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template><xsl:template match="LISTAEDITABLE" mode="init">

       

      
      <xsl:call-template name="SCROLLinit">
         <xsl:with-param name="nombre"><xsl:value-of select="concat('CpScroll',@nombre)"/></xsl:with-param>
      </xsl:call-template>
      

      
      

      <xsl:variable name="gb"><xsl:choose><xsl:when test="LINEAS/GROSOR/@borde"><xsl:value-of select="LINEAS/GROSOR/@borde"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:if test="CABECERA">
         <xsl:text>CpScroll</xsl:text><xsl:value-of select="@nombre"/>.asociax='CpCab<xsl:value-of select="@nombre"/>';CpScroll<xsl:value-of select="@nombre"/>.tipoAsoc='scrollInterno';CpScroll<xsl:value-of select="@nombre"/>.xoffset=<xsl:value-of select="$gb"/><xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="not(@init) or not(@init='N')">
         <xsl:value-of select="@nombre"/>
         <xsl:text>.init();</xsl:text>
      </xsl:if>

      <xsl:apply-templates mode="init"/>

   </xsl:template><xsl:template match="LISTAEDITABLE" mode="body">


      <xsl:variable name="incSX"><xsl:choose><xsl:when test="@incScrollx"><xsl:value-of select="@incScrollx"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSY"><xsl:choose><xsl:when test="@incScrolly"><xsl:value-of select="@incScrolly"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      
      <DIV ID="Cp{@nombre}">
         <xsl:if test="CABECERA">
            <xsl:apply-templates select="CABECERA"/>
         </xsl:if>
         <xsl:if test="TITULO">
            <DIV ID="CpTit{@nombre}">
               <xsl:if test="TITULO/@estilo">
                  <xsl:attribute name="style"><xsl:value-of select="TITULO/@estilo"/></xsl:attribute>
               </xsl:if>
            </DIV>
            <xsl:if test="(TITULO and not(GROSOR/@horizTitulo)) or (TITULO and not(GROSOR/@horizTitulo='0'))">
               <DIV ID="CpLTit{@nombre}"/>
            </xsl:if>
         </xsl:if>
         <xsl:if test="BASE">
            <DIV ID="CpBas{@nombre}"/>
            <xsl:if test="(BASE and not(GROSOR/@horizBase)) or (BASE and not(GROSOR/@horizBase='0'))">
               <DIV ID="CpLBas{@nombre}"/>
            </xsl:if>
         </xsl:if>
         <xsl:variable name="estiloScroll">
            <xsl:if test="DATOS/@estilo">
               <xsl:value-of select="DATOS/@estilo"/>
            </xsl:if>
         </xsl:variable>
         <xsl:call-template name="SCROLLbody">

            <xsl:with-param name="nombre">CpScroll<xsl:value-of select="@nombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="$incSX"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="$incSY"/></xsl:with-param>
            <xsl:with-param name="estilo"><xsl:value-of select="$estiloScroll"/></xsl:with-param>
         </xsl:call-template>
      </DIV>

      
      <DIV ID="CpLin1{@nombre}"/>
      <DIV ID="CpLin2{@nombre}"/>
      <DIV ID="CpLin3{@nombre}"/>
      <DIV ID="CpLin4{@nombre}"/>

      <xsl:apply-templates mode="body">

      </xsl:apply-templates>
      
   </xsl:template><xsl:template match="LISTAEDITABLE/CABECERA">
      <xsl:if test="@imgFondo or @colFondo">
         <DIV ID="CpFCab{../@nombre}"/>
      </xsl:if>
      <DIV ID="CpCab{../@nombre}">
         <xsl:if test="@estilo">
            <xsl:attribute name="style"><xsl:value-of select="@estilo"/></xsl:attribute>
         </xsl:if>
      </DIV>

      <xsl:variable name="ghc"><xsl:choose><xsl:when test="../LINEAS/GROSOR/@horizCabecera"><xsl:value-of select="../LINEAS/GROSOR/@horizCabecera"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:if test="../CABECERA and $ghc &gt; 0">
         <DIV ID="CpLCab{../@nombre}"/> 
      </xsl:if>
   </xsl:template><xsl:template match="LISTAEDITABLE/IMGBOTONES | LISTAEDITABLE/LINEAS | LISTAEDITABLE/COLUMNAS | LISTAEDITABLE/DATOS" mode="body">
   </xsl:template><xsl:template match="LISTAEDITABLE/TITULO" mode="body"/><xsl:template match="LISTAEDITABLE" mode="form">
      <INPUT TYPE="hidden" VALUE="">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
      </INPUT>
   </xsl:template><xsl:template match="MATRIZJS" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:text>DrMainEstatico.</xsl:text>
         <xsl:value-of select="@nombre"/>=<xsl:apply-templates select="ROWSET2|ROWSET|ROW|CAMPO" mode="generandomatriz"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="MATRIZJS" mode="script">
      <xsl:value-of select="@nombre"/>
      <xsl:text>=</xsl:text>
      <xsl:apply-templates select="ROWSET2|ROWSET|ROW|CAMPO" mode="generandomatriz"/>
      <xsl:text>;</xsl:text>
   </xsl:template><xsl:template match="ROWSET|ROWSET2|ROW" mode="generandomatriz">
      <xsl:text>[</xsl:text>
      <xsl:apply-templates select="ROWSET2|ROWSET|ROW|CAMPO" mode="generandomatriz"/>
      <xsl:text>]</xsl:text>
      <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
   </xsl:template><xsl:template match="CAMPO" mode="generandomatriz">
      <xsl:text>'</xsl:text>
      <xsl:call-template name="escapaCaracterYBarra">
          <xsl:with-param name="text" select="translate(translate(concat(.,@VALOR), '&#xd;',' '), '&#xA;',' ')"/>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>'</xsl:text>
      <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
   </xsl:template><xsl:template match="text()" mode="generandomatriz">
   </xsl:template><xsl:template match="TRAZAS">

<HTML>

<HEAD><title>MONITOR DRUIDA</title></HEAD>
   <BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" text="#000000" bgcolor="#8F4784">
	
	<TABLE width="100%" align="center" bgcolor="#8F4784" style="color:white;font-size:16px;font-weight:bold;font-family: Geneva, Arial, Helvetica, san-serif;">
		<TR height="36"><TD align="center">TRAZAS  DRUIDA</TD></TR>
	</TABLE>

<TABLE width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#FFEBD8">      
     
      <TR>
	 <TD bgcolor="#FFAD42" colspan="14" style="font-family: Arial, Helvetica, sans-serif; font-size: 13px; font-style: italic; line-height: normal; font-weight: bolder; font-variant: small-caps; text-transform: capitalize; color: #FFFFFF; text-align: left; text-indent: 4px; vertical-align: middle">TRAZAS</TD>     
      </TR> 
      
      <TD height="1"/>

      <TR ALIGN="LEFT" height="30" bgcolor="#FEB05F" style="color: #DA8823;background-color: #FADBB0;font-family: Geneva, Arial, Helvetica, san-serif;font-size: 11px;font-weight: bold;padding-right: 3px;padding-left: 7px;">
	 
		<TD align="center" width="25%" nowrap="">Tiempo</TD>
		<TD align="center" width="25%" nowrap="">Tipo</TD>
		<TD align="center" width="25%" nowrap="">Fecha</TD>
		<TD align="center" width="25%" nowrap="">Hora</TD>
		<TD align="center" width="25%" nowrap="">Dir. IP</TD>
		<TD align="center" width="25%" nowrap="">Id de la Traza</TD>
		<TD align="center" nowrap="">Usuario Remoto</TD>
		<TD align="center" width="25%" nowrap="">Objeto</TD>
		<TD align="center" width="25%" nowrap="">Tipo Negocio</TD>
		<TD align="center" width="25%" nowrap="">O. Afectado</TD>
		<TD align="center" width="25%" nowrap="">Tipo Secuencia</TD>
		<TD align="center" width="25%" nowrap="">Tipo Marca</TD>
		<TD align="center" width="25%" nowrap="">Valores Entrada</TD>
		<TD align="center" width="25%" nowrap="">Excepción</TD>
	</TR>

	<xsl:for-each select="T">
		
		
		
		
		

		<xsl:call-template name="TIPOTRAZAS"/>
	</xsl:for-each>

</TABLE>
   </BODY>
</HTML>
</xsl:template><xsl:template name="TIPOTRAZAS">


	<TR ALIGN="CENTER" style="font-family: Geneva, Arial, Helvetica, san-serif;font-size: 11px;color: #000000;background-color: #FFF1E3;padding-right: 3px;padding-left: 7px;">

		



		<TD bgcolor="FFF3E3"><xsl:value-of select="@a"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@b"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@c"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@d"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@e"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@f"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@g"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@h"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@i"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@j"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@k"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@l"/></TD>
		

		<TD bgcolor="FFF3E3"> 
		<xsl:choose>
			<xsl:when test="string-length(@m)&gt;0">
			<textarea style="font-size: 11px" name="comentario" rows="4" cols="10"><xsl:value-of select="@m"/></textarea> 
			</xsl:when> 

			<xsl:otherwise>
				VACIO
			</xsl:otherwise> 
		</xsl:choose>
		</TD>  


		<TD bgcolor="FFF7F0"> 
		<xsl:choose>
			<xsl:when test="string-length(.)&gt;0">
			<textarea style="font-size: 11px" name="comentario" rows="6" cols="40"><xsl:value-of select="."/></textarea> 
				
			</xsl:when> 
			<xsl:otherwise>
				VACIO
			</xsl:otherwise> 
		</xsl:choose>
		</TD>  

	    </TR>

</xsl:template><xsl:template match="GRUPOSOLAPAS" mode="head">
      <xsl:text>
</xsl:text>
      <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}d3gruposolapas.js"><xsl:text> </xsl:text></SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template><xsl:template match="GRUPOSOLAPAS" mode="init">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.init();</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template match="GRUPOSOLAPAS" mode="estilo">
      <xsl:text>.DrdCpIntSlp {position:absolute;height:100%;width:100%;overflow:auto;visibility: hidden;}
</xsl:text>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template><xsl:template match="GRUPOSOLAPAS" mode="script">
      <xsl:value-of select="@nombre"/>
      <xsl:text>=new ObjSolapas('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>',</xsl:text>
      <xsl:value-of select="count(SOLAPATEXTO)"/>
      <xsl:text>,</xsl:text>
      <xsl:value-of select="@solapaInicial"/>
      <xsl:text>,'</xsl:text>
      <xsl:value-of select="@claseTextoOff"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@claseTextoOn"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@imgIzqOff"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@imgIzqOn"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@imgFondoOff"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@imgFondoOn"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@imgDchaOff"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@imgDchaOn"/>
      <xsl:text>');</xsl:text>
      <xsl:apply-templates mode="script"/>
   </xsl:template><xsl:template match="GRUPOSOLAPAS" mode="body">
      <xsl:variable name="zindex">
         <xsl:choose>
            <xsl:when test="@zindex"><xsl:value-of select="@zindex"/></xsl:when>
            <xsl:otherwise>1</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>
      <xsl:variable name="altoCapas"><xsl:value-of select="(@alto - @altoReservado)"/></xsl:variable>
      <div id="{@nombre}_capas" style="position:absolute;width:{@ancho};height:{$altoCapas};z-index:{$zindex};left:{@x}px;top:{@y +  @altoReservado}px;">
         <table height="100%" width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
            <td height="1" width="1"><img src="{$imgPath}{MARCO/@imgEsquina11}"/></td>
            <td background="{$imgPath}{MARCO/@imgBordeSup}"><div style="width:1;height:1"><x/></div></td>
            <td width="1"><img src="{$imgPath}{MARCO/@imgEsquina12}"/></td>
           </tr>
           <tr>
            <td background="{$imgPath}{MARCO/@imgBordeIzq}"><div style="width:1;height:1"><x/></div></td>
            <td bgcolor="{MARCO/@colorFondo}">
               <xsl:for-each select="SOLAPATEXTO">
                  <div id="{../@nombre}_slp{(position() - 1)}" class="DrdCpIntSlp">
                     <xsl:apply-templates mode="body"/>
                  </div>
               </xsl:for-each>
            </td>
            <td background="{$imgPath}{MARCO/@imgBordeDcho}"><div style="width:1;height:1"><x/></div></td>
           </tr>
           <tr>
               <td height="1"><img src="{$imgPath}{MARCO/@imgEsquina21}"/></td>
               <td background="{$imgPath}{MARCO/@imgBordeInf}"><div style="width:1;height:1"><x/></div></td>
               <td><img src="{$imgPath}{MARCO/@imgEsquina22}"/></td>
           </tr>
         </table>
      </div>
      <div id="{@nombre}_botones" style="position:absolute;z-index:{$zindex};left:{@x}px;top:{@y}px;">
         <xsl:for-each select="SOLAPATEXTO">
            <xsl:variable name="indice">
               <xsl:value-of select="position() - 1"/> 
            </xsl:variable>
            <table id="drdtabl{$indice}" border="0" align="left" cellpadding="0" cellspacing="0" style="cursor:hand" onClick="{../@nombre}.solapas[{$indice}].click()">
               <tr>  
                  <xsl:choose>
                     <xsl:when test="../@solapaInicial=$indice">
                        <td><img id="imgIzq" src="{$imgPath}{../@imgIzqOn}"/></td>
                        <td id="cendCentr" background="{$imgPath}{../@imgFondoOn}" class="txtSolapaOn"><xsl:value-of select="@texto"/></td>
                        <td><img id="imgDcha" src="{$imgPath}{../@imgDchaOn}"/></td>
                     </xsl:when>
                     <xsl:otherwise>
                        <td><img id="imgIzq" src="{$imgPath}{../@imgIzqOff}"/></td>
                        <td id="cendCentr" background="{$imgPath}{../@imgFondoOff}" class="{../@claseTextoOff}"><xsl:value-of select="@texto"/></td>
                        <td><img id="imgDcha" src="{$imgPath}{../@imgDchaOff}"/></td>
                     </xsl:otherwise>
                  </xsl:choose>
               </tr>
            </table>
         </xsl:for-each>
      </div>
   </xsl:template><xsl:template match="SOLAPATEXTO" mode="head"><xsl:apply-templates mode="head"/></xsl:template><xsl:template match="SOLAPATEXTO" mode="init"><xsl:apply-templates mode="init"/></xsl:template><xsl:template match="SOLAPATEXTO" mode="script"><xsl:apply-templates mode="script"/></xsl:template><xsl:template match="SOLAPATEXTO" mode="body"><xsl:apply-templates mode="body"/></xsl:template><xsl:template match="SOLAPATEXTO" mode="estilo"><xsl:apply-templates mode="estilo"/></xsl:template><xsl:template name="CAMPOREQ">
      <xsl:text> </xsl:text>
      <xsl:if test="@req='S' and string-length($imgCampoRequerido) &gt; 0">
      
         <IMG>
            <xsl:attribute name="SRC">

               <xsl:value-of select="$vgImgPath"/>
               <xsl:value-of select="$imgCampoRequerido"/>
            </xsl:attribute>
         </IMG>
      </xsl:if>
   </xsl:template><xsl:template name="break">
   <xsl:param name="text" select="."/>
   <xsl:choose>
   <xsl:when test="contains($text, '&#xA;')">
      <xsl:value-of select="substring-before($text, '&#xA;')"/>
      <xsl:text>\r\n</xsl:text>
      <xsl:call-template name="break">
      <xsl:with-param name="text" select="substring-after($text,'&#xA;')"/>
      </xsl:call-template>
   </xsl:when>
   <xsl:otherwise>
   <xsl:value-of select="$text"/>
   </xsl:otherwise>
   </xsl:choose>
</xsl:template><xsl:template match="VAR" mode="dinamico">
      <xsl:if test="@drdModificado and @drdModificado='S'">
      
         <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
         <xsl:variable name="texto">
            <xsl:call-template name="break">
                <xsl:with-param name="text" select="@valor"/>
            </xsl:call-template>
         </xsl:variable>
         <xsl:text>
DrMainEstatico.set('</xsl:text>
         <xsl:value-of select="$vNombreFormulario"/>
         <xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:call-template name="escapa">
            <xsl:with-param name="text">
               <xsl:choose>
                  <xsl:when test="$noHacerNormalizeSpace='S'">
                     <xsl:value-of select="translate($texto, '&#xA;',' ')"/>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="normalize-space(translate($texto, '&#xA;',' '))"/>
                  </xsl:otherwise>
               </xsl:choose>
             </xsl:with-param>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="VAR" mode="init">
      <xsl:variable name="vNombreFormulario" select="ancestor::FORMULARIO/@nombre"/>
      
      <xsl:if test="$vgQuieroDruidaBack='S'">
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
         
         
         <xsl:call-template name="escapa">
             <xsl:with-param name="text">
               <xsl:choose>
                  <xsl:when test="$noHacerNormalizeSpace='S'">
                     <xsl:value-of select="translate($texto, '&#xA;',' ')"/>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="normalize-space(translate($texto, '&#xA;',' '))"/>
                  </xsl:otherwise>
               </xsl:choose>
             </xsl:with-param>
             <xsl:with-param name="caracter">'</xsl:with-param>
         </xsl:call-template>
         <xsl:text>');</xsl:text>
      </xsl:if>
   </xsl:template><xsl:template match="VAR" mode="script">
      <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>TC="Hidden";
</xsl:text>
   </xsl:template><xsl:template match="VAR" mode="form">
      <xsl:text>
</xsl:text>
      <INPUT TYPE="hidden">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:attribute name="VALUE">
            <xsl:choose>
               <xsl:when test="$noHacerNormalizeSpace='S'">
                  <xsl:value-of select="translate(@valor, '&#xA;',' ')"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="normalize-space(translate(@valor, '&#xA;',' '))"/>
               </xsl:otherwise>
            </xsl:choose>
         </xsl:attribute>
      </INPUT>

   </xsl:template><xsl:template name="FORMULARIOFINAL">

      <xsl:choose>
         <xsl:when test="substring($ProxyServlet,1,2)='nw'">
            <xsl:call-template name="FORMULARIOFINAL-NW"/>
         </xsl:when>

         <xsl:otherwise>

            <TABLE border="0" cellspacing="0" cellpadding="0">
               <TR><TD>
               <FORM METHOD="post">
                  <xsl:attribute name="NAME">
                     <xsl:value-of select="@nombre"/>
                  </xsl:attribute>



                  <xsl:if test="$DR_DEBUG_TIEMPOS='S'">
                     <INPUT TYPE="hidden" NAME="drd_tiempo_inicio" VALUE=""/>
                     
                     <INPUT TYPE="hidden" NAME="drd_cod_al" value="{$drd_cod_al}"/>
                     <INPUT TYPE="hidden" NAME="drd_comando" value="{$drd_comando}"/>
                     <INPUT TYPE="hidden" NAME="drd_perfil" value="{$drd_perfil}"/>
                     <INPUT TYPE="hidden" NAME="drd_pagina" value="{$drd_pagina}"/>
                     <INPUT TYPE="hidden" NAME="drd_tiempo_total"/>
                  </xsl:if>

                  
                     

                  

                  
                  <INPUT TYPE="hidden" NAME="DruidaArco" VALUE=""/>

                  <INPUT TYPE="hidden" NAME="drd_net" VALUE="{$drd_net}"/>
                  <INPUT TYPE="hidden" NAME="drd_evento" VALUE=""/>
                  <INPUT TYPE="hidden" NAME="drd_estado" VALUE="{$drd_estado}"/>
                  <INPUT TYPE="hidden" NAME="drd_loparam" VALUE=""/>

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

                  
                  
                  <xsl:call-template name="EXT.form"/>

                  <xsl:if test="not($pGeneroHTML='S')">
                     <xsl:for-each select="//HISTORY/ON">
                        <INPUT TYPE="hidden" NAME="d3history_{@nombre}" VALUE="{@parametros}"/>
                     </xsl:for-each>
                  </xsl:if>



                  <xsl:text>
</xsl:text>
               </FORM>
               </TD></TR>
            </TABLE>

         </xsl:otherwise>
      </xsl:choose>

   </xsl:template><xsl:template name="FORMULARIOFINAL-NW">
         <TABLE border="0" cellspacing="0" cellpadding="0">
            <TR><TD>
            <FORM METHOD="post">
               <xsl:attribute name="NAME">
                  <xsl:value-of select="@nombre"/>
               </xsl:attribute>
               

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
               <xsl:text>
</xsl:text>
            </FORM>
            </TD></TR>
         </TABLE>
   </xsl:template><xsl:template  match="text()" mode="head"/><xsl:template  match="text()" mode="estilo"/><xsl:template  match="text()" mode="script"/><xsl:template  match="text()" mode="dinamico"/><xsl:template  match="text()" mode="init"/><xsl:template  match="text()" mode="form"/><xsl:template  match="text()" mode="script-elem-form"/><xsl:template  match="*|@*" mode="script" priority="-100">

         <xsl:apply-templates mode="script">
           
         </xsl:apply-templates>
   </xsl:template><xsl:template  match="*" mode="dinamico">

      <xsl:apply-templates mode="dinamico">
        
      </xsl:apply-templates>
   </xsl:template><xsl:template  match="CABECERA|PRESENTACION|ROWSET|ROW|CAMPO|VAR" mode="body">
   </xsl:template><xsl:template  match="*|@*" mode="body" priority="-100">
       <xsl:copy>
           <xsl:apply-templates select="@*|node()" mode="body"/>
       </xsl:copy>
   </xsl:template><xsl:template  match="INPUT|@*" mode="form">
       <xsl:copy>
           <xsl:apply-templates select="@*|node()" mode="form"/>
       </xsl:copy>
   </xsl:template><xsl:template  match="IMG" mode="body">

      <xsl:variable name="vURI">
         <xsl:value-of select="concat($vgImgPath, @src)"/>
      </xsl:variable>

      <IMG SRC="{$vURI}">
         <xsl:copy-of select="@*[name()!='src']"/>
      </IMG>

   </xsl:template><xsl:template  match="TD" mode="body">
      <TD>
         <xsl:copy-of select="@*"/>
         <xsl:if test="@background!=''">
            <xsl:attribute name="background">
               <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@background"/>
            </xsl:attribute>
         </xsl:if>
         <xsl:apply-templates mode="body"/>
      </TD>
   </xsl:template><xsl:template  match="SELECT" mode="form">
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
   </xsl:template><xsl:template  match="@*|*">

       <xsl:copy>
           <xsl:apply-templates select="@*|node()"/>
       </xsl:copy>
   </xsl:template><xsl:template  match="PAGINA" mode="init">
      <xsl:apply-templates mode="init"/>
   </xsl:template><xsl:template  match="PAGINA" mode="script">
      


      <xsl:apply-templates mode="script">

      </xsl:apply-templates>
   </xsl:template><xsl:template  match="PAGINA" mode="body">


      <xsl:apply-templates mode="body">

      </xsl:apply-templates>
   </xsl:template><xsl:template  name="XMLATTR">
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
   </xsl:template><xsl:template  name="DELIMITA">
      <xsl:param name="cadena"/>
      <xsl:param name="sep"/>
      <xsl:value-of select="concat($sep,$cadena,$sep)"/>
   </xsl:template><xsl:template  match="JS|JAVASCRIPT|ESTILO|CACHEOS" mode="body">
   </xsl:template><xsl:template  name="escapa">
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
   </xsl:template><xsl:template  name="escapaRetornosDeCarro2">
      <xsl:param name="text"/>
      <xsl:choose>
      <xsl:when test="contains($text, '&#xd;')"> 
         <xsl:value-of select="substring-before($text, '&#xd;')"/>
         <xsl:text>\r</xsl:text>
         <xsl:call-template name="escapaRetornosDeCarro2">
             <xsl:with-param name="text" select="substring-after($text,'&#xd;')"/>
         </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
         <xsl:value-of select="$text"/>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="escapaRetornosDeCarro">
      <xsl:param name="text"/>
      <xsl:choose>
      <xsl:when test="contains($text, '&#xA;')">
         <xsl:value-of select="substring-before($text, '&#xA;')"/>
         <xsl:text>\n</xsl:text>
         <xsl:call-template name="escapaRetornosDeCarro">
             <xsl:with-param name="text" select="substring-after($text,'&#xA;')"/>
         </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
         <xsl:value-of select="$text"/>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="escapa2">
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
   </xsl:template><xsl:template  name="escapaCaracterYBarra">
   
   
      <xsl:param name="text"/>
      <xsl:param name="caracter"/>
      <xsl:variable name="vText" select="$text"/>
      <xsl:variable name="vCaracter" select="$caracter"/>
      <xsl:call-template name="escapaRetornosDeCarro2">
         <xsl:with-param name="text">
            <xsl:call-template name="escapaRetornosDeCarro">
               <xsl:with-param name="text">
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text">
                        <xsl:call-template name="escapa">
                           <xsl:with-param name="text" select="$vText"/>
                           <xsl:with-param name="caracter">\</xsl:with-param>
                        </xsl:call-template>
                     </xsl:with-param>
                     <xsl:with-param name="caracter" select="$vCaracter"/>
                  </xsl:call-template>
               </xsl:with-param>
            </xsl:call-template>
         </xsl:with-param>
      </xsl:call-template>
   </xsl:template><xsl:template  match="OCUPADO" mode="head">
         <SCRIPT TYPE="text/javascript">
            <xsl:attribute name="SRC">
               <xsl:value-of select="$jsDruidaPath"/>
               <xsl:text>d3ocupado.js</xsl:text>
            </xsl:attribute>
            <xsl:text> </xsl:text>
         </SCRIPT>
   </xsl:template><xsl:template  match="OCUPADO" mode="script">
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
   </xsl:template><xsl:template  match="OCUPADO" mode="body">
      
   </xsl:template><xsl:template  match="GRAFICO" mode="body">

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
   </xsl:template><xsl:template  name="OCUPADOFINAL">


      <xsl:variable name="NombreNodoPadre">
         <xsl:value-of select="../@nombre"/>
      </xsl:variable>


      <xsl:variable name="vFondo">
         <xsl:choose>
            <xsl:when test="@colorf or string-length(@colorf)&gt;0">
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

      <DIV ID="d3ocupado{$NombreNodoPadre}" style="position:absolute;visibility:hidden;{$vFondo}">
      <xsl:apply-templates mode="body">

      </xsl:apply-templates>
      </DIV>
   </xsl:template><xsl:template  match="INCLUIR-HTML" mode="body">
      <xsl:variable name="fichero" select="concat('../xml/gui/',@href)"/>

      <xsl:apply-templates select="document($fichero)/HTML/*"/>
   </xsl:template><xsl:template  match="HISTORY" mode="body">
      
   </xsl:template><xsl:template  name="SetTxtComponente.i10n">
      <xsl:choose>
         <xsl:when test="@cod">
            <xsl:call-template name="langtxt.i10n">
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
               <xsl:when test="string-length(@RC)&gt;0 and @RC='S'">
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text">
                        <xsl:call-template name="break">
                           <xsl:with-param name="text" select="$vTexto"/>
                        </xsl:call-template>
                     </xsl:with-param>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate($vTexto, '&#xA;', ' ')"/>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:otherwise>
             </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="SetTxtComponente">
      <xsl:choose>
         <xsl:when test="@cod">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@cod"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="string-length(@RC)&gt;0 and @RC='S'">
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text">
                        <xsl:call-template name="break">
                           <xsl:with-param name="text" select="@valor"/>
                        </xsl:call-template>
                     </xsl:with-param>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate(@valor, '&#xA;',' ')"/>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:otherwise>
             </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="langtxt"> 
      <xsl:param name="pCod"/>
      <xsl:choose>
         <xsl:when test="$vLangExist">
            <xsl:value-of select="drdcambia:drd30_Traducir($vLang,$pCod)" disable-output-escaping="yes"/>
        </xsl:when>
        <xsl:otherwise>
            <xsl:value-of select="$pCod"/><xsl:text>-Idioma no definido</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="langtxt.i10n">
      <xsl:param name="pCod"/>
      <xsl:choose>
         <xsl:when test="$vLangExist">
            <xsl:value-of select="drdcambia:drd30_Traducir($vLang,$pCod)" disable-output-escaping="yes"/>
        </xsl:when>
        <xsl:otherwise>
            <xsl:value-of select="$pCod"/>
        </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="label.tooltip.script">
      <xsl:if test="@tooltip">
         <xsl:variable name="vTxt">
            <xsl:call-template name="langtxt.i10n">
               <xsl:with-param name="pCod" select="@tooltip"/>
            </xsl:call-template>
         </xsl:variable>
         <xsl:value-of select="@nombre"/>
         <xsl:text>.tooltip='</xsl:text>
         <xsl:choose>
            <xsl:when test="string-length($vTxt)=0 and $vgForzarTooltip and $vgForzarTooltip='S'">
               <xsl:value-of select="@tooltip"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="$vTxt"/>
           </xsl:otherwise>
         </xsl:choose>
         <xsl:text>'; </xsl:text>
      </xsl:if>
   </xsl:template><xsl:template  name="label.tooltip2.script">
      <xsl:choose>
         <xsl:when test="@tooltip">
            <xsl:variable name="vTxt">
               <xsl:call-template name="langtxt.i10n">
                  <xsl:with-param name="pCod" select="@tooltip"/>
               </xsl:call-template>
            </xsl:variable>
            <xsl:text>'</xsl:text>
            <xsl:choose>
               <xsl:when test="string-length($vTxt)=0 and $vgForzarTooltip and $vgForzarTooltip='S'">
                  <xsl:value-of select="@tooltip"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$vTxt"/>
              </xsl:otherwise>
            </xsl:choose>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>null</xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  name="DrdImgPath">
      <xsl:choose>
         <xsl:when test="$vLangExist">
            <xsl:value-of select="$imgPath[lang($vLang)]"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$imgPath"/>
        </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template  match="DRUIDABUILDER" mode="body">
   </xsl:template><xsl:template  match="LONAVEGACION" mode="script">
      <xsl:text>DrdCierraCargandoDeOpener();</xsl:text>
      <xsl:choose>
         <xsl:when test="ERROR">
            <xsl:text>
               if (window.tipoNavLo &amp;&amp; tipoNavLo=="VENTANA")
                  var wref=opener;
               else
                  var wref=parent;
               onerror=wref.DrControlaError;</xsl:text>
               <xsl:choose>
                  <xsl:when test="$pLoModal='SI'">
wref.muestraMsgErrorLOModal("<xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="ERROR/text()"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template>","<xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="$pLoModalFeatures"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template>","<xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="$pLoModalUrl"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template>");
</xsl:when>
                  <xsl:otherwise>
wref.muestraMsgError("OCURRIÓ UN ERROR: \n<xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="ERROR/text()"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template>");
</xsl:otherwise>
               </xsl:choose>
               <xsl:text>
               wref.vNavLO=false;
               if (window.tipoNavLo &amp;&amp; tipoNavLo=="VENTANA")
                  close();
            </xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>
               if (window.tipoNavLo &amp;&amp; tipoNavLo=="VENTANA")
                  var wref=opener;
               else
                  var wref=parent;
               onerror=wref.DrControlaError;
               wref.DrdCargaRedONavega_2("</xsl:text><xsl:value-of select="EVENTO/text()"/><xsl:text>","</xsl:text><xsl:value-of select="ESTADO/text()"/><xsl:text>","</xsl:text><xsl:value-of select="RED/text()"/><xsl:text>","</xsl:text><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="LOPARAMETROS/text()"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template><xsl:text>");
               if (window.tipoNavLo &amp;&amp; tipoNavLo=="VENTANA")
                  close();
            </xsl:text>
            
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template><xsl:template xmlns:drdencb64="es.indra.druida.util.DruidaEncodingBase64" match="/">
      <xsl:apply-templates/>
   </xsl:template><xsl:template xmlns:drdencb64="es.indra.druida.util.DruidaEncodingBase64" match="PAGINA">
      <xsl:choose>
         <xsl:when test="$pDinamico='S'">
            <xsl:call-template name="PAGINA-dinamico"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="PAGINA-estatico"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template><xsl:template xmlns:drdencb64="es.indra.druida.util.DruidaEncodingBase64" name="PAGINA-dinamico">
      <HTML>
         <HEAD>
            <META NAME="Author" CONTENT="INDRA Sistemas, S.A."/>
            <META NAME="Generator" CONTENT="Druida 3.0"/>
            <TITLE>
               <xsl:value-of select="@titulo"/>
            </TITLE>
            <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1"/>
            <SCRIPT>
               <xsl:text>
function drdSets(elDocument) {</xsl:text>
               <xsl:apply-templates mode="dinamico">
    
               </xsl:apply-templates>
               <xsl:text>
</xsl:text>

               
                                 
               <xsl:call-template name="EXT.dinamico"/>

               <xsl:value-of select="$pJS"/>

               <xsl:text>
var formulariosUsuario='|</xsl:text>
               <xsl:for-each select="//FORMULARIO">
                  <xsl:value-of select="@nombre"/>
                  <xsl:text>|</xsl:text>
               </xsl:for-each>
               <xsl:text>';
</xsl:text>

               <xsl:text>
var elstrform='</xsl:text>

               <xsl:for-each select="//HISTORY/ON">
                  <xsl:text disable-output-escaping="yes">&lt;INPUT TYPE="hidden" NAME="d3history_</xsl:text>
                  <xsl:value-of select="@nombre"/>
                  <xsl:text disable-output-escaping="yes">" VALUE="</xsl:text>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text">
                        <xsl:value-of select="translate(@parametros, '&#xA;',' ')"/>
                     </xsl:with-param>
                      <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
                  <xsl:text disable-output-escaping="yes">"&gt;</xsl:text>
               </xsl:for-each>
               <xsl:text>';
</xsl:text>

               <xsl:text disable-output-escaping="yes">var f=0;
for (f=0;f&lt;elDocument.forms.length;f++)   {
</xsl:text>
               <xsl:text disable-output-escaping="yes">if(formulariosUsuario.indexOf('|'+elDocument.forms[f].name+'|')!=-1) {
</xsl:text>               
               <xsl:text disable-output-escaping="yes">elDocument.forms[f].innerHTML=elDocument.forms[f].innerHTML+elstrform;
}
</xsl:text>
               <xsl:text disable-output-escaping="yes">}
</xsl:text>
               <xsl:text>
 if (DrMainEstatico.oculta_asignar) {DrMainEstatico.d3ocupado_ocultar('d3general');} 
</xsl:text>
               <xsl:text>}
</xsl:text>
               <xsl:text>
onLoadUsua='</xsl:text>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text">
                     <xsl:value-of select="translate(@onload, '&#xA;',' ')"/>
                  </xsl:with-param>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
               <xsl:text>';
</xsl:text>
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
   </xsl:template><xsl:template xmlns:drdencb64="es.indra.druida.util.DruidaEncodingBase64" name="PAGINA-estatico">
      <xsl:variable name="vgPosicionCapaOcupado">
         <xsl:choose>
            <xsl:when test="$vLangExist">
               <xsl:value-of select="$vgOcupado/CAPA[lang($vLang)]/@posicion"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="$vgOcupado/CAPA[1]/@posicion"/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>
      <xsl:variable name="vgCapaOcupado" select="$vgOcupado/CAPA[1]"/>
      <xsl:variable name="vgCapaOcupadoLang" select="$vgOcupado/CAPA[lang($vLang)]"/>
      <HTML>
         <HEAD>
            <META NAME="Author" CONTENT="INDRA Sistemas, S.A."/>
            <META NAME="Generator" CONTENT="Druida 3.0"/>

            <xsl:if test="$DR_DEBUG_JS='S'">
               <SCRIPT>tiempos=[new Date()]</SCRIPT>
            </xsl:if> 

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
            <xsl:if test="@estilos and string-length(@estilos)&gt;0">
               <LINK REL="stylesheet" TYPE="text/css">
                  <xsl:attribute name="HREF">
                     <xsl:value-of select="$cssPath"/>
                     <xsl:value-of select="@estilos"/>
                  </xsl:attribute>
               </LINK>
            </xsl:if>
            <xsl:text>
</xsl:text>
            <SCRIPT>

               <xsl:if test="$vgQuieroDruidaBack='S'">
                  <xsl:text>DBck=true;</xsl:text>
               </xsl:if>

               <xsl:text>colReadOnly='</xsl:text>
               <xsl:value-of select="$vgColReadOnly"/>
               <xsl:text>';</xsl:text>

               <xsl:text>txtCmpReq='</xsl:text>
               <xsl:value-of select="$vgTxtCampoRequerido"/>
               <xsl:text>';</xsl:text>

               
               <xsl:text>imgTransp="</xsl:text>
               <xsl:value-of select="$imgTranspPath"/>
               <xsl:text>";</xsl:text>

               <xsl:if test="$vgTrimAlEnviarText='S'">
                  <xsl:text>TRIM_TEXT=true;</xsl:text>
               </xsl:if>
         
               <xsl:if test="$vgTrimAlEnviarAreaTexto='S'">
                  <xsl:text>TRIM_AREATEXTO=true;</xsl:text>
               </xsl:if>

               <xsl:if test="$vgRequeridoIgnoraEspacios='S'">
                  <xsl:text>reqIgnEsp=true;</xsl:text>
               </xsl:if>

               <xsl:text>tipoTooltip="</xsl:text><xsl:value-of select="$vgTipoTooltip"/><xsl:text>";</xsl:text>
               <xsl:text>tooltipEstilo="</xsl:text><xsl:value-of select="$vgEstiloTooltip"/><xsl:text>";</xsl:text>

               <xsl:if test="not($vgTipoAsignarJs='')">
                  <xsl:text>tipoAsignarJs="</xsl:text><xsl:value-of select="$vgTipoAsignarJs"/><xsl:text>";</xsl:text>
               </xsl:if>

               <xsl:if test="$vgModificar[@COMPONENTE='LABELC' and @OPCION='SiVacioQuitarEstilo']">
                  <xsl:text>LABC_SVQE=true;</xsl:text>
               </xsl:if>

	      </SCRIPT>
         
         
	      <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}base.js">              
            <xsl:text> </xsl:text>
         </SCRIPT>
         <SCRIPT>

               
               <xsl:if test="$vgConfig/DATOSPROY/ALERTMODAL">
                  <xsl:text>alertModal=new drdAlertModal("</xsl:text>
                  <xsl:value-of select="$vgConfig/DATOSPROY/ALERTMODAL/ON"/>
                  <xsl:text>","</xsl:text>
                  <xsl:value-of select="$vgConfig/DATOSPROY/PROXYSERVLET"/>
                  <xsl:text>",</xsl:text>
                  
                  <xsl:choose>
                     <xsl:when test="$vgConfig/DATOSPROY/ALERTMODAL/CARACTERISTICAS">
                        <xsl:text>"</xsl:text>
                        <xsl:value-of select="$vgConfig/DATOSPROY/ALERTMODAL/CARACTERISTICAS"/>
                        <xsl:text>"</xsl:text>
                     </xsl:when>
                     <xsl:otherwise>null</xsl:otherwise>
                  </xsl:choose>
                  
                  <xsl:if test="$vgConfig/DATOSPROY/ALERTMODAL/FJS">
                     <xsl:text>,"</xsl:text>
                     <xsl:value-of select="$vgConfig/DATOSPROY/ALERTMODAL/FJS"/>
                     <xsl:text>"</xsl:text>
                  </xsl:if>
                  <xsl:text>);</xsl:text>
               </xsl:if>

               
               <xsl:if test="$DR_DEBUG_JS='S'">
                  <xsl:text>DR_DEBUG_JS=true;</xsl:text>
               </xsl:if>



            </SCRIPT>

            


            
            <SCRIPT TYPE="text/javascript">
            <xsl:text>function DrdImgPath(){return '</xsl:text><xsl:call-template name="DrdImgPath"/><xsl:text>';};</xsl:text>
            <xsl:for-each select="CACHEOS/CACHEAR">
               <xsl:text>DrdPrecImg('</xsl:text>
               <xsl:value-of select="@img"/>
               <xsl:text>',true);</xsl:text>
            </xsl:for-each>
            </SCRIPT>

            
            <xsl:apply-templates mode="head">

            </xsl:apply-templates>

            
            <xsl:if test="//COMBO">

               <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}d3combo.js"><xsl:text> </xsl:text></SCRIPT>
            </xsl:if>

            
                              
            <xsl:call-template name="EXT.head"/>

            
            <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}d3ocupado.js">
               <xsl:text> </xsl:text>
            </SCRIPT>
            
            <xsl:choose>
               <xsl:when test="$vgMultiIdioma and $vgMultiIdioma='S' and $vLangExist and not($vLang='es')">
                  <SCRIPT TYPE="text/javascript" SRC="{$rutaEntV}entornoV_{$vLang}.js"><xsl:text> </xsl:text></SCRIPT>
               </xsl:when>
               <xsl:otherwise>
                  <SCRIPT TYPE="text/javascript" SRC="{$rutaEntV}entornoV.js"><xsl:text> </xsl:text></SCRIPT>
               </xsl:otherwise>
            </xsl:choose>
            <SCRIPT TYPE="text/javascript">
               <xsl:attribute name="SRC">
                  <xsl:value-of select="$jsDruidaPath"/>
                  <xsl:text>valida.js</xsl:text>
               </xsl:attribute>
              <xsl:text> </xsl:text>
            </SCRIPT>
            
            <xsl:choose>
               <xsl:when test="$vLangExist and not($vLang='es')">
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
            
           <xsl:if test="$vLangExist">
               <SCRIPT TYPE="text/javascript" SRC="{$jsPath}mensajes-{$vLang}.js">
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if> 

            
            <xsl:if test="//BOTON">
               <SCRIPT TYPE="text/javascript">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$jsDruidaPath"/>
                     <xsl:text>boton.js</xsl:text>
                  </xsl:attribute>
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if>


            <xsl:if test="//LISTA[@seleccion='fila'][1]">
               <SCRIPT TYPE="text/javascript">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$jsDruidaPath"/>
                     <xsl:text>d3listafila.js</xsl:text>
                  </xsl:attribute>
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if>

            <xsl:if test="//LISTA[not(@seleccion='fila')][1]">
               <SCRIPT TYPE="text/javascript">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$jsDruidaPath"/>
                     <xsl:text>listadoa.js</xsl:text>
                  </xsl:attribute>
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if>




             
            <xsl:if test="@drdRunner='S'">
               <SCRIPT TYPE="text/javascript" SRC="{$jsPath}drdRunner.js">
               
               <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if> 


            <xsl:for-each select="JS">
               <SCRIPT TYPE="text/javascript">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$jsPath"/><xsl:value-of select="@src"/>
                  </xsl:attribute>
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:for-each>




            <xsl:if test="$pPersonalizable='S'">
               <SCRIPT TYPE="text/javascript" SRC="{$ProxyServlet}?ON=EntornoV">
                  <xsl:text> </xsl:text>
               </SCRIPT>
            </xsl:if>

            <xsl:text>
</xsl:text>
            <STYLE TYPE="text/css">

                  <xsl:value-of select="ESTILO"/>

                  <xsl:text>
#DRUIDA {position:absolute;left:0;top:0;visibility:hidden;}</xsl:text>
                  <xsl:apply-templates mode="estilo">

                  </xsl:apply-templates>

            
                              
            <xsl:call-template name="EXT.estilo"/>

                  <xsl:text>
</xsl:text>
            </STYLE>
            <xsl:text>
</xsl:text>

            <SCRIPT TYPE="text/javascript">


                  

                  <xsl:value-of select="JAVASCRIPT/."/>
                  <xsl:text>;</xsl:text>


<xsl:text>evSalida=[</xsl:text><xsl:value-of select="$pDruidaArcosOut"/><xsl:text>];</xsl:text>
<xsl:text>evSalidaTipo=[</xsl:text><xsl:value-of select="$pDruidaTipoArcosOut"/><xsl:text>];</xsl:text>

<xsl:text>drdNombrePagina='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>';</xsl:text>

                  <xsl:if test="$vLangExist">
                     <xsl:text>
function DrdIdioma(){return '</xsl:text><xsl:value-of select="$vLang"/><xsl:text>';} </xsl:text>
                  </xsl:if>


                  <xsl:if test="@msgle!=''">
                     <xsl:text>defaultStatus='</xsl:text>
                     <xsl:value-of select="@msgle" disable-output-escaping="yes"/>
                     <xsl:text>';</xsl:text>
                  </xsl:if>

                  
                  <xsl:apply-templates mode="script">

                  </xsl:apply-templates>

                  
                  
                  <xsl:call-template name="EXT.script"/>

                  


                  

   <xsl:text>
function drdOnLoad(){</xsl:text>

   
   <xsl:if test="$vgOcupado/OCULTAR/@OPCION and translate($vgOcupado/OCULTAR/@OPCION ,'abcdefghijklmnñopqrstuvwxyz','ABCDEFGHIJKLMNÑOPQRSTUVWXYZ') = 'ONLOAD'">DrdCierraCargandoDeOpener();</xsl:if>



   

   

   <xsl:apply-templates mode="init"/>

   
                  
   <xsl:call-template name="EXT.init"/>

   <xsl:text>}
</xsl:text>var d3_PS='<xsl:value-of select="$ProxyServlet"/>';requeridoS='<xsl:value-of select="$vgColReq"/>';requeridoN='<xsl:value-of select="$vgColNoReq"/>';deshabilitadoColor='<xsl:value-of select="$vgColDeshabilitados"/>';<xsl:if test="string-length($vgDisableFontSize)&gt;0">disableFontSize="<xsl:value-of select="$vgDisableFontSize"/>";</xsl:if>
      <xsl:if test="string-length($vgEnableFontSize)&gt;0">enableFontSize="<xsl:value-of select="$vgEnableFontSize"/>";</xsl:if>
      <xsl:text>if (labelRC==null||labelRC==''){labelRC="</xsl:text><xsl:value-of select="$vglabelRC"/><xsl:text>";}</xsl:text>
      
      <xsl:if test="$vOcupadoAsignarJS = 'S'">oculta_asignar=true;</xsl:if> 
      <xsl:if test="$vOcupadoPaginado = 'S'">oculta_paginado=true;</xsl:if> 
      <xsl:if test="$vOcupadoFrmCOculto = 'S'">oculta_frmOculto=true;</xsl:if> 
      <xsl:if test="$vOcupadoFichero='S'">ocupado_fichero=true;</xsl:if>
      <xsl:if test="$vOcupadoEnvia='S'">ocupado_envia=true;</xsl:if>
      <xsl:if test="$vOcupadoLista='S'">ocupado_lista=true;</xsl:if>
      <xsl:if test="$vOcupadoBloquea='S'">ocupado_bloquea=true;</xsl:if>

      <xsl:if test="$vgOcupado/MOSTRAR[@OPCION='Bloquea']/ONCLICK">
         <xsl:text>ocupado_bloquea_onclick='</xsl:text>
         <xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="$vgOcupado/MOSTRAR[@OPCION='Bloquea']/ONCLICK"/><xsl:with-param name="caracter">'</xsl:with-param></xsl:call-template>
         <xsl:text>';</xsl:text>
      </xsl:if>
      
      
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
      <xsl:text>;var d3ocupado_general='</xsl:text><xsl:value-of select="$vPos"/><xsl:text>';</xsl:text>
      </SCRIPT>
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
                     <xsl:choose>      
                       <xsl:when test="@repimagenf!='N'"><xsl:text>repeat</xsl:text></xsl:when>
                       <xsl:otherwise><xsl:text>no-repeat</xsl:text></xsl:otherwise>
                     </xsl:choose>
                  </xsl:if>
                </xsl:attribute>

               <xsl:attribute name="onLoad">

                  <xsl:if test="$DR_DEBUG_JS='S'">drdEvTmp();</xsl:if>

 

                  <xsl:if test="$pGeneroHTML='S'">
                     <xsl:text>if(oculta_asignar){d3ocupado_ver('d3general',d3ocupado_general);}</xsl:text>
                  </xsl:if>


                  <xsl:text>drdOnLoad();</xsl:text>

                  <xsl:choose>
                     <xsl:when test="$pGeneroHTML='S'">
                        <xsl:text>parent.drdSets(document);eval(parent.onLoadUsua);</xsl:text>
                     </xsl:when>
                     <xsl:otherwise>
                        <xsl:value-of select="@onload"/>
                     </xsl:otherwise>
                  </xsl:choose> 
	               <xsl:text>;loadValoresPagina();</xsl:text>
                  <xsl:value-of select="@onback"/>

                  
                  


                  <xsl:if test="$DR_DEBUG_JS='S'">
                     <xsl:text>drdEvTmp();drdEvaluaProblemas(true);</xsl:text>
                  </xsl:if>

               </xsl:attribute>


               <xsl:attribute name="onUnload">
                  
                  <xsl:value-of select="@onunload"/>
	            </xsl:attribute>

               <DIV ID="DRUIDA">
			   
               <IMG style="visibility:hidden" height="1">
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


               
               <DIV ID="d3ocupadod3general" style="position:absolute;visibility:hidden;z-index:1000">
                  <xsl:choose>
                     <xsl:when test="$vLangExist">
                              <xsl:apply-templates select="$vgCapaOcupadoLang/*"/>
                     </xsl:when>
                     <xsl:otherwise>
                              <xsl:apply-templates select="$vgCapaOcupado/*"/>
                     </xsl:otherwise>
                  </xsl:choose> 
               </DIV>      

               
               <xsl:apply-templates mode="body">

               </xsl:apply-templates>

               
               
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
                  <xsl:if test="$vgTipoAsignarJs='AJAX'">
                     <INPUT TYPE="hidden" NAME="tipoAsignar" value="AJAX"/>
                  </xsl:if>
               </FORM>
               
            </BODY>
      </HTML>
   </xsl:template><xsl:template xmlns:drdencb64="es.indra.druida.util.DruidaEncodingBase64" match="/FICHERO">
      <xsl:variable name="vSep">
         <xsl:choose>
            <xsl:when test="@separador='TAB'"><xsl:text>	</xsl:text></xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="@separador"/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>
         
      <xsl:for-each select="ROWSET/ROW">

         <xsl:choose>

            
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
               <xsl:text>
</xsl:text>
            </xsl:otherwise>
         </xsl:choose>
         

      </xsl:for-each> 

   </xsl:template>


   
   <xsl:template match="TABLEDIT" mode="estilo">
		.button { font-size:10; }
      body,table,form {background-color: white; margin: 0px 0px 0px 0px; text-align:left;font-family:Verdana, Arial, Helvetica; font-size: 10px;}
   </xsl:template><xsl:template match="TABLEDIT" mode="body">
   <xsl:variable name="vNombreTE" select="@nombre"/>

			<form name="{$vNombreTE}" id="{$vNombreTE}">
			   <xsl:variable name="onclickaddrow">
               <xsl:apply-templates select="PRESENTACION" mode="addrow"/>
            </xsl:variable>
				<INPUT class="button" id="Button1" onclick="{$onclickaddrow}" type="button" value="Add article" name="Button1"/>
				<input type="button" value="Delete article" onclick="deleter()" class="button" name="del" id="del"/>
				<br/>
				<table id="{$vNombreTE}_table" border="1">
					<TBODY>
				     <xsl:apply-templates select="CABECERA" mode="body"/>
					</TBODY>
				</table>
				<br/>

		   	<input type="hidden" name="count" ID="Hidden1"/>
		   	<input type="hidden" name="lst_list" ID="Hidden1"/>
			</form>
			<script language="javascript">
var max = 10 //maximum rows
var color = "red";
var selected_row = 0;


document.write ("\&lt;\script language='JavaScript'&gt;");
for(i=1;i&lt;(max + 1);i++)

{
 funct_name = "funct_row" + i;
 document.write ("function " + funct_name +"()");
 document.write ("{");
 document.write ("end_color();");
 row_name = "row" + i;
 document.write (row_name+".style.backgroundColor='"+color+"';");
 document.write ("selected_row = "+ i +";");
 document.write ("}");
}

  document.write ("&lt;\/script&gt;");


function end_color()
{
 if (selected_row != 0)
 {
  object = eval("row"+selected_row);
  object.style.backgroundColor ='white';
 }
}

function setcolor()
{
  index = 'row1';
  object = eval(index);
  object.style.backgroundColor = "red";
}

   <xsl:apply-templates select="PRESENTACION" mode="addrowdef"/>
{
 // count the number of rows from a table
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 if (numrows == max + 1)
 {
   alert("You can only add "+ max + " articles!");
 }
 else
 {
   var newRow = document.all.<xsl:value-of select="$vNombreTE"/>_table.insertRow(numrows);
   document.<xsl:value-of select="$vNombreTE"/>.count.value = numrows;

   <xsl:apply-templates select="PRESENTACION" mode="body"/>


   <xsl:value-of select="$vNombreTE"/>_table.rows.item(numrows).id = "row" + numrows;
   <xsl:value-of select="$vNombreTE"/>_table.rows.item(numrows).name = "row" + numrows;
   funct_name = eval("funct_row" + numrows);
   row_name = eval("row"+numrows);
   row_name.attachEvent("onclick",funct_name);
 }
}

function deleter()
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 if (numrows != 1)
 {
   if(selected_row == 0)
   {
     <xsl:value-of select="$vNombreTE"/>_table.deleteRow(numrows-1);
     document.<xsl:value-of select="$vNombreTE"/>.count.value = numrows - 2;
   }
   else
   {
     getval(selected_row);
     <xsl:value-of select="$vNombreTE"/>_table.deleteRow(selected_row);
     changef(selected_row);
     document.<xsl:value-of select="$vNombreTE"/>.count.value = numrows - 2;
   }
 }
  selected_row = 0;
}

function changef(index)
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 numrows = numrows + 1;
for(i = index + 1;i&lt;numrows;i++)
 {
  plus = i+1
  min = i-1;
  row_name = eval("row" + i);

  row_name.cells(0).innerHTML = "&lt;b&gt;&lt;center&gt;"+ min +"&lt;center&gt;&lt;/b&gt;";

  row_name2 = "row" + min;
  funct_name = eval("funct_row" + i);
  row_name.detachEvent("onclick",funct_name);
  row_name.name = row_name2;
  row_name.id = row_name2;
  funct_name = eval("funct_row" + min);
  row_name2 = eval(row_name2);
  row_name2.attachEvent("onclick",funct_name);
 }
}

function getval(index)
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 numrows = numrows -1;

 for (i = index;i &lt; numrows;i++)

 {
  obj_list = eval("document.<xsl:value-of select="$vNombreTE"/>.lst_list" + i);
  obj_list2 = eval("document.<xsl:value-of select="$vNombreTE"/>.lst_list" + (i+1));
  obj_count = eval("document.<xsl:value-of select="$vNombreTE"/>.txt_count" + i);
  obj_count2 = eval("document.<xsl:value-of select="$vNombreTE"/>.txt_count" + (i+1));
  obj_list.options[obj_list2.options.selectedIndex].selected = true;
  obj_count.value = obj_count2.value;
  
 }
 for (i = numrows ;i &gt; index;i--)
 {
  row_name = eval("row" + (i-1));
  row_name2 = eval("row" + i);
  row_name2.cells(1).innerHTML = row_name.cells(1).innerHTML
  row_name2.cells(2).innerHTML = row_name.cells(2).innerHTML
 }
}


function values()
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 str = "";
 str += "count = " + document.<xsl:value-of select="$vNombreTE"/>.count.value +"\n";

 for(i=1;i&lt;numrows;i++)

 {
  obj_list = eval("document.<xsl:value-of select="$vNombreTE"/>.lst_list"+i);
  obj_count = eval("document.<xsl:value-of select="$vNombreTE"/>.txt_count"+i);
  str += obj_list.name + ": "+ obj_list.options[obj_list.selectedIndex].text+"    "+obj_count.name+": "+obj_count.value+"\n";
 }
 alert(str);
}
	   <xsl:apply-templates select="ROWSET/ROW" mode="addrow"/>
	</script>
			

  </xsl:template><xsl:template match="TABLEDIT/CABECERA" mode="body">
    <tr id="tr1"><xsl:apply-templates mode="body"/></tr>
  </xsl:template><xsl:template match="TABLEDIT/CABECERA/COL" mode="body">
    <td><b><xsl:value-of select="."/></b></td>
  </xsl:template><xsl:template match="TABLEDIT/PRESENTACION" mode="body">
    <xsl:apply-templates mode="body"/>
  </xsl:template><xsl:template match="TABLEDIT/PRESENTACION/TETEXT" mode="body">
    inner =  "&lt;input type='text'";
    <xsl:if test="@style">inner += "' style='<xsl:value-of select="@style"/>'";</xsl:if>
    <xsl:if test="@id">inner += "' id='<xsl:value-of select="@id"/>'";</xsl:if>
    <xsl:if test="@onclick">inner += "' onclick='"+<xsl:value-of select="@onclick"/>+"'";</xsl:if>
    <xsl:if test="@size">inner += "' size='<xsl:value-of select="@size"/>'";</xsl:if>
    <xsl:if test="@max">inner += "' max='<xsl:value-of select="@max"/>'";</xsl:if>
    <xsl:if test="@valor">inner += "' value='"+<xsl:value-of select="@nombre"/>+"'";</xsl:if>

    name = "<xsl:value-of select="@nombre"/>" + numrows;
    inner += " name='"+name+"'&gt;";
    (newRow.insertCell()).innerHTML = inner;
  </xsl:template><xsl:template match="TABLEDIT/PRESENTACION/TECOMBO" mode="body" priority="-1">
    inner =  "&lt;select ";
    <xsl:if test="@style">inner += "' style='<xsl:value-of select="@style"/>'";</xsl:if>
    <xsl:if test="@id">inner += "' id='<xsl:value-of select="@id"/>'";</xsl:if>
    <xsl:if test="@onclick">inner += "' onclick='"+<xsl:value-of select="@onclick"/>+"'";</xsl:if>
    <xsl:if test="@onchange">inner += "' onchange='"+<xsl:value-of select="@onchange"/>+"'";</xsl:if>
    name = "<xsl:value-of select="@NOMBRE"/>" + numrows;
    inner += " name='"+name+"'&gt;";
    <xsl:apply-templates select="ROWSET/ROW" mode="body"/>
    inner += "&lt;/select&gt;";
    (newRow.insertCell()).innerHTML = inner;
  </xsl:template><xsl:template match="TABLEDIT/PRESENTACION/TECOMBO/ROWSET/ROW" mode="body">
    inner += "<option><xsl:value-of select="CAMPO"/></option>";
  </xsl:template><xsl:template match="TABLEDIT/PRESENTACION" mode="addrowdef">
  function addrow(<xsl:apply-templates select="TETEXT|TECOMBO" mode="addrowdef"/>)</xsl:template><xsl:template match="TABLEDIT/PRESENTACION/*" mode="addrowdef">
   <xsl:if test="position()&gt;1">,</xsl:if><xsl:value-of select="@nombre"/>
  </xsl:template><xsl:template match="TABLEDIT/PRESENTACION" mode="addrow">addrow(<xsl:apply-templates select="TETEXT|TECOMBO" mode="addrow"/>);</xsl:template><xsl:template match="TABLEDIT/PRESENTACION/*" mode="addrow"><xsl:if test="position()&gt;1">,</xsl:if>'<xsl:value-of select="@valor"/>'</xsl:template><xsl:template match="TABLEDIT/ROWSET/ROW" mode="addrow">addrow(<xsl:apply-templates select="CAMPO" mode="addrow"/>);</xsl:template><xsl:template match="TABLEDIT/ROWSET/ROW/CAMPO" mode="addrow"><xsl:if test="position()&gt;1">,</xsl:if>'<xsl:value-of select="."/>'</xsl:template>

</xsl:stylesheet>