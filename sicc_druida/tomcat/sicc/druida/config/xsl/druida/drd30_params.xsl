<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_params.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
   Parametros de la tranformacion Druida
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <!-- Parametros declarados aqui poruq druida debe tener el control -->

   <xsl:param name="vDruidaNavegador">Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; xxxxxxx)</xsl:param>

   <!-- Recogemos el arco de entrada -->
   <xsl:param name="pDruidaArcoIn">null</xsl:param>

   <!-- Recogemos los arcos de salida -->
   <xsl:param name="pDruidaArcosOut">'a','b','c'</xsl:param>

   <xsl:param name="pPersonalizable">N</xsl:param>

   <!-- Recogemos el Place -->
   <xsl:param name="pDruidaPlace">null</xsl:param>

   <!-- Recogemos el parámetro de debug javascript -->
   <xsl:param name="DR_DEBUG_JS">N</xsl:param>

   <xsl:param name="DR_DEBUG_TIEMPOS">N</xsl:param> <!-- ==S se activa el calculo de tiempos -->
   <xsl:param name="drd_tiempo_inicio"></xsl:param><!-- esto se lo pasa una pantalla a otra para calcular -->
   <xsl:param name="drd_tiempo_servlet"></xsl:param><!-- servlet al que hay que llamar para grabar (DrdOnTiempos ?) -->
   <xsl:param name="drd_cod_al"></xsl:param><!-- los necesita el servlet al grabar -->
   <xsl:param name="drd_comando"></xsl:param><!-- los necesita el servlet al grabar -->

   <!-- Recogemos el parámetro para transformacion normal o solo a datos, parte dinamica de la pagina -->
   <!--<xsl:param name="pDinamico">S</xsl:param>-->
   <xsl:param name="pDinamico"></xsl:param>

   <!-- Recogemos el parámetro que define el nombre de la pagina html cacheada -->
   <!--<xsl:param name="pHTMLEstatico">../cache/cacheada</xsl:param>-->
   <xsl:param name="pHTMLEstatico"></xsl:param>

   <!-- Recogemos el parámetro que contiene la parte javascript generado en java. Para solventar el problema de la modificacion de atributos en la logica de presentacion -->
   <xsl:param name="pJS"></xsl:param>

   <xsl:param name="pGeneroHTML"></xsl:param>


</xsl:stylesheet >

