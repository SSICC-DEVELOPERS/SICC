<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output encoding="ISO-8859-1" method="xml" indent="yes"/>

	<xsl:variable name="cantidadColumnas">
		<xsl:value-of select="count(//COL)"/>
	</xsl:variable>



	<xsl:template match="//MATRIX">
		<div>

		<SCROLL nombre="miscroll" x="25" y="40" ancho="750" alto="280" colorf="#CECFCE" visibilidad="visible" incx="10" incy="10" colores="">

		<!-- Ajuste opcional, sino toma valores por defecto -->
		<xsl:if test="@xMatrix">
			<xsl:attribute name="x"><xsl:value-of select="@xMatrix"></xsl:value-of></xsl:attribute>
		</xsl:if>
		<xsl:if test="@yMatrix">
			<xsl:attribute name="y"><xsl:value-of select="@yMatrix"></xsl:value-of></xsl:attribute>
		</xsl:if>
		<xsl:if test="@anchoMatrix">
			<xsl:attribute name="ancho"><xsl:value-of select="@anchoMatrix"></xsl:value-of></xsl:attribute>
		</xsl:if>
		<xsl:if test="@nombreScroll">
			<xsl:attribute name="nombre"><xsl:value-of select="@nombreScroll"></xsl:value-of></xsl:attribute>
		</xsl:if>
		<!--  -->

		<table width="100%" border="1" style="border-collapse:collapse;">
			<colgroup>
				<col></col>
				<xsl:for-each select="//COL">
					<col>
						<xsl:attribute name="id">
							<xsl:choose>
								<xsl:when test="number(position() mod 2)=number(0)">
									<xsl:text>EstDat2</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>EstDat</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
						</xsl:attribute>
					</col>
				</xsl:for-each>
			</colgroup>
			<tr bgcolor="#CECFCE">
				<th align="left" colspan="{$cantidadColumnas+1}" id=""><LABELC ancho="300" alto="13" filas="1" valor="" id="datosTitle">
				<xsl:attribute name="nombre"><xsl:text>titulo_</xsl:text><xsl:value-of select="generate-id()"/><xsl:value-of select="@cod"/></xsl:attribute>
				<xsl:attribute name="cod"><xsl:value-of select="@cod"></xsl:value-of></xsl:attribute></LABELC></th>
			</tr>
			<xsl:if test="//COL[@name]">
				<tr  bgcolor="#CECFCE"><td rowspan="2" style="padding-left:7px">
					<LABELC ancho="100" alto="13" filas="1" valor="" id="datosTitle">
						<xsl:attribute name="nombre"><xsl:value-of select="generate-id()"/></xsl:attribute>
						<xsl:attribute name="cod"><xsl:value-of select="./COLUMNS/@cod"></xsl:value-of></xsl:attribute>
					</LABELC>
				</td>
				<xsl:apply-templates select="COLUMNS" mode="nombres" /></tr>
			</xsl:if>
			<tr  bgcolor="#CECFCE">
			<xsl:if test="not(//COL[@name])">
				<td>
					<LABELC ancho="120" alto="13" filas="1" valor="" id="EstCab">
						<xsl:attribute name="nombre"><xsl:value-of select="generate-id()"/></xsl:attribute>
						<xsl:attribute name="cod"><xsl:value-of select="./COLUMNS/@cod"></xsl:value-of></xsl:attribute>
					</LABELC>
				</td>
			</xsl:if>
			<xsl:apply-templates select="COLUMNS" /></tr>
			<xsl:apply-templates select="ROWS"/>
		</table>
		</SCROLL>
			<CAPA nombre="capaBotones" alto="23" ancho="99%" colorf="#CECFCE" borde="0" visibilidad="visible" x="25" y="338">
				<xsl:if test="//BOTON">
						<xsl:for-each select="//BOTON">
							<xsl:copy-of select="."/>
						</xsl:for-each>
				</xsl:if>
				<xsl:if test="//MATRIX[@xMatrix]">
					<xsl:attribute name="x"><xsl:value-of select="@xMatrix"></xsl:value-of></xsl:attribute>
				</xsl:if>
				<xsl:if test="//MATRIX[@yBotones]">
					<xsl:attribute name="y"><xsl:value-of select="@yBotones"></xsl:value-of></xsl:attribute>
				</xsl:if>
			</CAPA>
		</div>
	</xsl:template>


	<xsl:template match="COL">
		<td id="EstCab" nowrap="nowrap">
			<xsl:value-of select="@name" disable-output-escaping="yes"/>
		</td>
	</xsl:template>

	<xsl:template match="COLUMNS" mode="nombres">
		<xsl:for-each select="COL">
			<td id="EstCab" align="center" nowrap="nowrap"><xsl:value-of select="@name"/></td>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="COLUMNS">
		<xsl:for-each select="COL">
			<td id="EstCab" align="center" nowrap="nowrap" style="width:120px"><xsl:value-of select="@label"/></td>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="ROWS">
		<xsl:apply-templates select="ROW"/>
	</xsl:template>

	<xsl:template match="ROW">
		<xsl:variable name="actual" select="."></xsl:variable>
		<tr>
			<td bgcolor="#CECFCE" id="EstCab" nowrap="nowrap" style="width:150px"><xsl:value-of select="@label"></xsl:value-of></td>
			<xsl:for-each select="//COL">
				<xsl:variable name="columna"><xsl:value-of select="position()"/></xsl:variable>
				<td valign="middle" align="center">
					<xsl:apply-templates select="$actual/CELL[@col=$columna]"/>
				</td>
			</xsl:for-each>
		</tr>
	</xsl:template>

	<xsl:template match="CELL">
		<a style="text-decoration:none;cursor:hand">
		<xsl:if test="@color">
			<xsl:attribute name="style">
				<xsl:text>text-decoration:none;cursor:hand;color:</xsl:text>
				<xsl:value-of select="@color"></xsl:value-of>
			</xsl:attribute>
		</xsl:if>
		<xsl:if test="@url">
		<xsl:attribute name="onclick">
			<xsl:value-of select="@url"></xsl:value-of>
		</xsl:attribute>
		</xsl:if>
		<xsl:value-of select="@label"></xsl:value-of>
		</a><br/>
	</xsl:template>
</xsl:stylesheet>