<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!--Esto define el encabezado del xml de salida-->
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" encoding="ISO-8859-1"></xsl:output>
	<xsl:strip-space elements="*"></xsl:strip-space>
	<!--
		/**
		 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
		 * Avda. de Bruselas, 35
		 * Parque Empresarial Arroyo de la Vega
		 * 28108 Alcobendas, Madrid
		 * España
		 *
		 * Privado y Confidencial.
		 * La información contenida en este documento es propiedad de Indra sistemas.
		 * Para uso exclusivo de empleados autorizados no permitiéndose
		 * la distribución de este código sin permiso expreso.
		 */
		/*********************************************************************************************************
		 * Sistema:           	Belcorp
		 * Modulo:            	MEN 
		 * Submódulo:         	Menú
		 * Componente:       	Presentar Menu
		 * Fecha:             	13/05/2003
		 * Observaciones:    Plantilla generadora del menu dinamico a partir del conector 
		 * @version           	1.0
		 * @autor             	Gaston Acevedo
		 *********************************************************************************************************/
	-->
	<!--aca se hace la transformacion-->
	<xsl:template match="/">
    <MENU nombre="CArbol" tipo="vertical" x="0" y="0" ancho="256" alto="1500" version="2"  estiloSelecc="menuMarcado"      
			colorf="#999999" 
			espnivel1="7" 
			espnivel2="1" 
			margennivel1="0" 
			margennivel2="7" 
			altofila="19"
			imagenf="transparente.gif" 
			imgdesplegarS="transparente.gif" 
			imgdesplegarN="transparente.gif" 
			imgplegarS="transparente.gif" 
			imgplegarN="transparente.gif" 
			iconiv1N="transparente.gif"
			iconiv1S="transparente.gif"
			iconiv2N="flechaMenuHorzG.gif"
			iconiv2S="flechaMenuVertG.gif"
			imgfondoniv1 = "imgfondoniv1.gif"
			imgfondoniv2 = "imgfondoniv2.gif"
			imgfondoniv3 = "imgfondoniv3.gif"
			imgfondoniv4 = "imgfondoniv4.gif"
         posh="0">
            		<xsl:apply-templates select="//ROWSET"></xsl:apply-templates>
		</MENU>
	</xsl:template>

	<xsl:template  match="ROWSET">
		<xsl:apply-templates select="./ROW[CAMPO[@NOMBRE='jerarquia']='F0001' and CAMPO[@NOMBRE='idfuncion']='F0002']">
		</xsl:apply-templates>
	
		<xsl:apply-templates select="./ROW[CAMPO[@NOMBRE='jerarquia']='F0001' and CAMPO[@NOMBRE='idfuncion']!='F0001' and CAMPO[@NOMBRE='idfuncion']!='F0002']">
			<xsl:sort select="CAMPO[@NOMBRE='nombrefuncion']" ></xsl:sort>
		</xsl:apply-templates>
	</xsl:template>

	
	
	<xsl:template  match="ROW">
		<!--Este sirve nada mas que para ordenar, ahora los proceso
			ahora llamo al template que se encarga del laburo	-->
		<xsl:call-template name="proceso">
			<xsl:with-param name="jerarquia" select="CAMPO[@NOMBRE='idfuncion']"></xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	
	<xsl:template name="proceso">
		<!--
		Aca hago la tranformacion, este es un template recursivo que se llama por nombre
		espera como parametro la jerarquia que esta laburando, es decir el idFuncion del Padre
		para colgarle los hijos.
		-->
		<xsl:param name="jerarquia"></xsl:param>
		<xsl:choose>
			<xsl:when test="(CAMPO[@NOMBRE='nodofinal'])=0">
				<!--
					Si no es un nodo final, genero la entrada SUBMENU y salgo a buscar los hijos
					de este, usando el idFuncion como Jerarquia de los mismos
				-->
				<SUBMENU>
					<xsl:attribute name="nombre">
						<xsl:value-of select="CAMPO[@NOMBRE='idfuncion']" disable-output-escaping="yes"></xsl:value-of>
					</xsl:attribute>
					<xsl:attribute name="info">
						<xsl:value-of select="CAMPO[@NOMBRE='nombrefuncion']" disable-output-escaping="yes"></xsl:value-of>
					</xsl:attribute>
					<!--
					Selecciono los Nodos que tienen la misma jerarquia, es decir aquellos que cuelgan del mismo padre
					y llamo a este mismo template, siempre y cuando el nodo no sea el mismo en el que estoy parado,
					pasando como parametro el idFuncion actual, que sera la jerarquia de sus hijos
					-->
					<xsl:for-each select="//ROW[CAMPO[@NOMBRE='jerarquia']=$jerarquia and . != current() ]">
						<xsl:sort select="CAMPO[@NOMBRE='nombrefuncion']" ></xsl:sort>
						<xsl:call-template name="proceso">
							<xsl:with-param name="jerarquia" select="CAMPO[@NOMBRE='idfuncion']"></xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</SUBMENU>
			</xsl:when>
			<xsl:otherwise>
				<!--
					Es nodo final, genero la hoja y salgo de la llamada recursiva
				-->
				<ENTRADA>
					<xsl:attribute name="info">
						<xsl:value-of select="CAMPO[@NOMBRE='nombrefuncion']" disable-output-escaping="yes"></xsl:value-of>
					</xsl:attribute>
					<xsl:choose>
						<xsl:when test="(CAMPO[@NOMBRE='habilitado'])!=0">
							<!--
							La funcion esta habilitada para el Usuario
							-->
							<xsl:if test="(CAMPO[@NOMBRE='nombreprograma'])!=''">
								<xsl:attribute name="enlace" >
									<xsl:text disable-output-escaping="yes"><![CDATA[menu(']]></xsl:text><xsl:value-of select="CAMPO	[@NOMBRE='nombreprograma']"></xsl:value-of><xsl:text disable-output-escaping="yes"><![CDATA[&idFuncion=]]></xsl:text><xsl:value-of select="CAMPO	[@NOMBRE='idfuncion']" disable-output-escaping="yes"></xsl:value-of><xsl:text disable-output-escaping="yes"><![CDATA[');void(null);]]></xsl:text>
								</xsl:attribute>
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>
							<!--
							La funcion no esta habilitada para el Usuario
							-->
							<xsl:attribute name="enlace">
								<xsl:text>void(null);</xsl:text>
							</xsl:attribute>						
						</xsl:otherwise>
					</xsl:choose>
				</ENTRADA>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>