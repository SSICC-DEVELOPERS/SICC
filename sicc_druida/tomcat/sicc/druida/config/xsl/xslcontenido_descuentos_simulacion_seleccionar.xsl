<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
accion="SeleccionarSolicitud();"   $Id: xslcontenido_descuentos_simulacion_seleccionar.xsl,v 1.1 2009/12/03 19:02:34 pecbazalar Exp $
   DESC
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" indent="yes" method="xml"
		omit-xml-declaration="no" version="1.0"/>
	<xsl:strip-space elements="*"/>
	<xsl:variable name="ALTO_CAPA" select="172"/>
	<xsl:key match="ROW" name="laKey" use="concat(CAMPO[5],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9])"/>
	<xsl:variable name="labelCampana">210</xsl:variable>
	<xsl:variable name="labelFecha">110</xsl:variable>


	<xsl:template match="//ROWSET2">
		<xsl:apply-templates select="ROWSET[@ID='dtoSalida.resultado_ROWSET']"/>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:variable name="agrupaciones" select="count(ROW[count(. | key('laKey', concat(CAMPO[5],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9]) )[1]) = 1])"/>
		<xsl:variable name="cant_rows" select="count(ROW)"/>
		<xsl:variable name="tamScroll" select="((number($agrupaciones)*41)+(number($cant_rows)*20))+20"/>
		<!--xsl:for-each select="ROW[count(. | key('laKey', concat(CAMPO[1],'__',CAMPO[4],'__',CAMPO[5],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9]) )[1]) = 1]">
			<xsl:variable name="tamanoScroll" select="count(. | key('laKey', concat(CAMPO[1],'__',CAMPO[4],'__',CAMPO[5],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9]) )[1])"/>
			<xsl:value-of select="$tamanoScroll"/>
			<xsl:variable name="tamanoScroll2" select="concat(CAMPO[1],'__',CAMPO[4],'__',CAMPO[5],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9])"/>
			<xsl:value-of select="$tamanoScroll2"/>
		</xsl:for-each-->
		<CAPA alto="100%" ancho="100%" colborde="" colorf="" contravsb=""
			imagenf="" nombre="CapaPrincipalAbajoXSL" padding="" repeat=""
			visibilidad="visible" x="12" y="510" z-index="">
			<!--SCROLL nombre="ScrollRejilla" x="0" y="0" ancho="569" alto="{$tamScroll}"  
			colorf="" visible="visible" incx="10" incy="510"-->
			<xsl:variable name="posicion" select="position()"/>
			<TABLE align="left" name="tablaDelXSL" border="0" cellpadding="0" cellspacing="0" width="100%">
				<TR>
					<TD colspan="6" valign="top">
						<TABLE border="1" bordercolor="#CCCCCC" cellpadding="1"
							cellspacing="0" width="100%">
							<TR>
								<TD class="fondoCabecera">
									<LABELC alto="20" ancho="80" cod="3"
										filas="1" id="datosTitleLeft" nombre="lblSeleccion"/>
								</TD>
								<TD class="fondoCabecera">
									<LABELC alto="20" ancho="1000" cod="850"
										filas="1" id="datosTitleLeft" nombre="lblSolicitud"/>
								</TD>
							</TR>
							<xsl:for-each select="ROW[count(. | key('laKey', concat(CAMPO[5],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9]) )[1]) = 1]">
								<!--xsl:variable name="y" select="15+(   (number($posicion)-1)  * (number($ALTO_CAPA)+15)    )"/-->
								<!-- creamos una variable hidden-->
								<TR>
									<!-- Ahora debemos crear la tabla para todo esto. -->
									<xsl:variable name="PK2" select="concat(CAMPO[5],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9])"/>
									<xsl:variable name="pkKey" select="concat(CAMPO[5],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[6],'__',CAMPO[7], '__',CAMPO[8], '__',CAMPO[9])"/>
									<TD valign="top">
										<CHECKBOX check="N" id="datosCampos"
										nombre="chk{$PK2}"
										onclick="agregarCodigo('{$PK2}');"
										onfocus="" req="N" texto="" validacion=""/>
									</TD>
									<TD>
										<TABLE align="left" border="0"
										cellpadding="0" cellspacing="0" width="100%">
										<TR height="20">
										<!--Tomamos el los parámetros de la cabecera -->
										<td class="fondoCabecera">
										<IMG height="2" src="b.gif" width="8"/>
										</td>
										<xsl:variable name="nomCliente" select="concat(CAMPO[@NOMBRE='APE1'],' ', CAMPO[@NOMBRE='APE2'],' ',CAMPO[@NOMBRE='NOM1'],' ',CAMPO[@NOMBRE='NOM2'])"/>
										<TD class="fondoCabecera"
										height="20" width="51">
										<LABELC alto="20" ancho="51"
										cod="2049" filas="1"
										id="datosTitleLeft" nombre="lbl1Client{$PK2}"/>
										</TD>
										<TD class="fondoCabecera" width="350">
										<LABELC alto="20"
										ancho="320" filas="1"
										id="datosTitleLeft"
										nombre="lblClient{$PK2}" valor="{$nomCliente}"/>
										</TD>
										<xsl:variable name="campana" select="CAMPO[@NOMBRE='NOM_PERI']"/>
										<TD class="fondoCabecera" width="70">
										<LABELC alto="20" ancho="70"
										cod="2050" filas="1"
										id="datosTitleLeft" nombre="lbl1Campana{$PK2}"/>
										</TD>
										<TD class="fondoCabecera" width="{$labelCampana}">
										<LABELC alto="20"
										ancho="{$labelCampana}" filas="1"
										id="datosTitleLeft"
										nombre="lblCampana{$PK2}" valor="{$campana}"/>
										</TD>
										<xsl:variable name="fecha" select="CAMPO[@NOMBRE='FECH_FACTU']"/>
										<TD class="fondoCabecera" width="48">
										<LABELC alto="20" ancho="48"
										cod="2051" filas="1"
										id="datosTitleLeft" nombre="lbl1Fecha{$PK2}"/>
										</TD>
										<TD class="fondoCabecera" width="{$labelFecha}">
										<LABELC alto="20"
										ancho="{$labelFecha}" filas="1"
										id="datosTitleLeft"
										nombre="lblFecha{$PK2}" valor="{$fecha}"/>
										</TD>
										<xsl:variable name="monto" select="CAMPO[@NOMBRE='IMP_MONT']"/>
										<TD class="fondoCabecera" width="80">
										<LABELC alto="20" ancho="80"
										cod="2052" filas="1"
										id="datosTitleLeft" nombre="lbl1Monto{$PK2}"/>
										</TD>
										<TD class="fondoCabecera" width="80">
										<LABELC alto="20" ancho="80"
										filas="1"
										id="datosTitleLeft"
										nombre="lblMonto{$PK2}" valor="{$monto}"/>
										</TD>
										</TR>
										<TR>
										<TD colspan="9">
										<TABLE border="1"
										bordercolor="#CCCCCC"
										cellpadding="0"
										cellspacing="0" width="100%">
										<TR>
										<TD colspan="1" width="250">
										<LABELC
										alto="20"
										ancho="250"
										cod="593"
										filas="1"
										id="datosCamposCabecera" nombre="lblDescripcion{$PK2}"/>
										</TD>
										<TD colspan="1" width="100">
										<LABELC
										alto="20"
										ancho="100"
										cod="594"
										filas="1"
										id="datosCamposCabecera" nombre="lblCant{$PK2}"/>
										</TD>
										<TD colspan="1" width="125">
										<LABELC
										alto="20"
										ancho="125"
										cod="885"
										filas="1"
										id="datosCamposCabecera" nombre="lblPrecioUnit{$PK2}"/>
										</TD>
										<TD colspan="1" width="125">
										<LABELC
										alto="20"
										ancho="125"
										cod="513"
										filas="1"
										id="datosCamposCabecera" nombre="lblValTot{$PK2}"/>
										</TD>
										<TD colspan="1" width="398">
										<LABELC
										alto="20"
										ancho="413"
										cod="595"
										filas="1"
										id="datosCamposCabecera" nombre="lblDescuent{$PK2}"/>
										</TD>
										</TR>
										<xsl:for-each select="key('laKey', $pkKey)">
										<xsl:apply-templates
										mode="crea_row" select="."/>
										</xsl:for-each>
										</TABLE>
										</TD>
										</TR>
										</TABLE>
									</TD>
								</TR>
							</xsl:for-each>
							<!--xsl:apply-templates mode="crea_row" select="//ROWSET[@ID='DATOS']/ROW"/-->
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD class="fondoCabecera">
						<BOTON ID="botonContenido"
							accion="javascript:siguiente();" cod="3"
							estado="true" nombre="btnSeleccionarSolicitud" tipo="html" ontab="javaScript:Primero();"/>
					</TD>
				</TR>
				<TR>
					<TD width="40">
						<IMG height="20" src="b.gif" width="40"/>
					</TD>
				</TR>
			</TABLE>
			<!--/SCROLL-->
		</CAPA>
	</xsl:template>
	<xsl:template match="ROW" mode="crea_row">
		<xsl:variable name="posicion" select="position()"/>
		<TR>
			<TD class="datosCamposCenterImpar" colspan="1">
				<xsl:variable name="DdP" select="CAMPO[@NOMBRE='DES_SAP']"/>
				<xsl:if test="$DdP='' ">
					<IMG height="2" src="b.gif" width="2"/>
				</xsl:if>
				<xsl:value-of select="$DdP"/>
			</TD>
			<TD class="datosCamposRightPar" colspan="1">
				<xsl:variable name="cant" select="CAMPO[@NOMBRE='NUM_UNID_POR_ATEN']"/>
				<xsl:if test="$cant='' ">
					<IMG height="2" src="b.gif" width="2"/>
				</xsl:if>
				<xsl:value-of select="$cant"/>
			</TD>
			<TD class="datosCamposRightImpar" colspan="1">
				<xsl:variable name="pu" select="CAMPO[@NOMBRE='PREC_CATA']"/>
				<xsl:if test="$pu='' ">
					<IMG height="2" src="b.gif" width="2"/>
				</xsl:if>
				<xsl:value-of select="$pu"/>
			</TD>
			<TD class="datosCamposRightPar" colspan="1">
				<xsl:variable name="vT" select="number(CAMPO[@NOMBRE='PREC_CATA'])* number(CAMPO[@NOMBRE='NUM_UNID_POR_ATEN'])"/>
				<xsl:if test="number($vT)">
					<xsl:value-of select="$vT"/>
				</xsl:if>
				<xsl:if test="string($vT)='NaN'">
					<IMG height="2" src="b.gif" width="2"/>
				</xsl:if>
			</TD>
			<TD class="datosCamposCenterImpar" colspan="1">
				<xsl:variable name="desc" select="CAMPO[@NOMBRE='IMP_TOTA_DESC']"/>
				<xsl:if test="$desc='' ">
					<IMG height="2" src="b.gif" width="2"/>
				</xsl:if>
				<xsl:value-of select="$desc"/>
			</TD>
		</TR>
	</xsl:template>

</xsl:stylesheet>
