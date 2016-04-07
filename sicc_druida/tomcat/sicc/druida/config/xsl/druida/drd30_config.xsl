<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_config.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
   Definicion de variables generales
-->


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">


   <!-- El proyecto debe definir en proyecto.xsl una variable vgConfig 
   xsl:variable name="vgConfig" select="document('../xml/globales.xml')" 
   
   
   Ademas se estan declarando las variables siguientes y deberian estar aqui

   <xsl:variable name="cssPath" select="$vgConfig/DATOSPROY/CSSPATH"/>
   <xsl:variable name="jsPath" select="$vgConfig/DATOSPROY/JSPATH"/>
   <xsl:variable name="imgPath" select="$vgConfig/DATOSPROY/IMGPATH[1]"/>
   <xsl:variable name="drdPath" select="$vgConfig/DATOSPROY/DRDPATH"/>
   <xsl:variable name="imgCampoRequerido" select="$vgConfig/DATOSPROY/IMAGENES/CAMPOREQ/ICONO"/>
   <xsl:variable name="ProxyServlet" select="$vgConfig/DATOSPROY/PROXYSERVLET"/>
   <xsl:variable name="imgTransparente" select="$vgConfig/DATOSPROY/IMAGENES/ESPACIADO/ICONO"/>
   
   -->


   <!-- determino si la navegacion viene dada por una red de Petri -->
   <xsl:variable name="vgPetri">
      <xsl:choose>
        <xsl:when test="$pDruidaArcosOut != 'null'">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose>
   </xsl:variable>


   <!-- si interesa se puede extraer también la versión -->
   <xsl:variable name="vNavegador">
      <xsl:choose>
        <xsl:when test="contains($vDruidaNavegador,'MSIE')">IE</xsl:when>
        <xsl:otherwise>NS</xsl:otherwise>
      </xsl:choose>
   </xsl:variable>


   <!-- Variable general internacionalizada ubicacion de las imagenes en funcion del xsm:lang de la PAGINA -->
   <xsl:variable name="vgImgPath">
      <xsl:call-template name="DrdImgPath"/>
   </xsl:variable>

   <xsl:variable name="imgTranspPath">
      <xsl:value-of select="$vgImgPath"/>
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/IMAGENES/ESPACIADO/ICONO">
            <xsl:value-of select="$vgConfig/DATOSPROY/IMAGENES/ESPACIADO/ICONO"/>
         </xsl:when>
         <xsl:otherwise>transparente.gif</xsl:otherwise>
      </xsl:choose>
   </xsl:variable>


   <xsl:variable name="imgDruidaPath">
      <xsl:value-of select="concat($drdPath,'img/')"/>
    </xsl:variable>
   <xsl:variable name="jsDruidaPath">
      <xsl:value-of select="concat($drdPath,'js/')"/>
    </xsl:variable>

   <!-- Muestro la capa de ocupado al asignar desde Javascript -->
   <xsl:variable name="vOcupadoAsignarJS">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='AsignarJS']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- Muestro la capa de ocupado al paginar -->
   <xsl:variable name="vOcupadoPaginado">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Paginado']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- Muestro la capa de ocupado al enviar un formulario en ventana oculta -->
   <xsl:variable name="vOcupadoFrmCOculto">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='FrmCOculto']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- Muestro la capa de ocupado al subir un fichero -->
   <xsl:variable name="vOcupadoFichero">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Fichero']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- Muestro la capa de ocupado al Enviar (navegacion paginas) -->
   <xsl:variable name="vOcupadoEnvia">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Envia']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- Muestro la capa de ocupado en las listas (lapsus carga/muestra de una lista)-->
   <xsl:variable name="vOcupadoLista">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Lista']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- desactivar la pagina de detras mientras se muestra la capa ocupado -->
   <xsl:variable name="vOcupadoBloquea">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/OCUPADO/MOSTRAR[@OPCION='Bloquea']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <xsl:variable name="vgScrollResize" select="$vgConfig/DATOSPROY/SCROLLRESIZE"/>
   <xsl:variable name="vgColReadOnly" select="$vgConfig/DATOSPROY/COLORREADONLY"/>
   <xsl:variable name="vgColReq" select="$vgConfig/DATOSPROY/COLORCREQ"/>
   <xsl:variable name="vgColNoReq" select="$vgConfig/DATOSPROY/COLORCNOREQ"/>
   <xsl:variable name="vgColDeshabilitados" select="$vgConfig/DATOSPROY/COLORCDES"/>
   <xsl:variable name="vgDisableFontSize" select="$vgConfig/DATOSPROY/DISABLEFONTSIZE"/>
   <xsl:variable name="vgEnableFontSize" select="$vgConfig/DATOSPROY/ENABLEFONTSIZE"/>
   <xsl:variable name="vgFormElementID" select="$vgConfig/DATOSPROY/FORMELEMENTID"/>
   <xsl:variable name="vgRadioCheckColorOnText" select="$vgConfig/DATOSPROY/RADIOCHECKCOLORONTEXT"/>
   <xsl:variable name="vglabelRC" select="$vgConfig/DATOSPROY/LABELRC"/>

   <xsl:variable name="vLang" select="/PAGINA/@xml:lang"/>
   <xsl:variable name="vgTxtCampoRequerido">
      <xsl:choose>
         <xsl:when test="/PAGINA/@xml:lang">
            <xsl:value-of select="$vgConfig/DATOSPROY/IMAGENES[lang($vLang)]/CAMPOREQ/TEXTO"/>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vgConfig/DATOSPROY/IMAGENES/CAMPOREQ/TEXTO"/>
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <xsl:variable name="vgEstiloTooltip">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/TOOLTIP">
            <xsl:value-of select="$vgConfig/DATOSPROY/TOOLTIP"/>
         </xsl:when>
         <xsl:otherwise>background-color:#FFFFDF;font-family:arial;font-size:10pt</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- tipo preferente de tooltip -->
   <xsl:variable name="vgTipoTooltip">
      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/TIPOTOOLTIP">
            <xsl:value-of select="$vgConfig/DATOSPROY/TIPOTOOLTIP"/>
         </xsl:when>
         <xsl:otherwise></xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- req='S' salta si solo hay espacios o no -->
   <xsl:variable name="vgRequeridoIgnoraEspacios">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/MODIFICAR[@COMPONENTE='VALIDACIONES' and @OPCION='requeridoIgnoraEspacios']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <!-- req='S' salta si solo hay espacios o no -->
   <xsl:variable name="vgTrimAlEnviarText">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/MODIFICAR[@COMPONENTE='TEXT' and @OPCION='trimAlEnviar']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

   <xsl:variable name="vgTrimAlEnviarAreaTexto">
      <xsl:choose>
        <xsl:when test="$vgConfig/DATOSPROY/MODIFICAR[@COMPONENTE='AREATEXTO' and @OPCION='trimAlEnviar']">S</xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable>

</xsl:stylesheet >

