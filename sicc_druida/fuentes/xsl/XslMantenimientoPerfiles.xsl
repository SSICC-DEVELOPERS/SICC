<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
   $Id: XslMantenimientoPerfiles.xsl,v 1.1 2009/12/03 19:02:41 pecbazalar Exp $
   DESC
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="no" encoding="ISO-8859-1" omit-xml-declaration="no"/>

	<xsl:template match="/">
			<xsl:apply-templates select="//ROWSET2"></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="ROWSET2">
		<table name="tblFunciones" style="table-layout:fixed;border-collapse:collapse" >
			<colgroup>
				<col width="567"></col>
				<col width="155"></col>
				<col width="105"></col>
			</colgroup>
			<xsl:apply-templates select="./ROWSET[@ID='dtoSalida.resultado_ROWSET']"/>
		</table>
	</xsl:template>
	
	<xsl:template match="ROWSET">
		<xsl:apply-templates select="ROW[(CAMPO[@NOMBRE='indicadornivel'])=1]">
			<xsl:sort select="CAMPO[@NOMBRE='nombrefuncion']"></xsl:sort>
		</xsl:apply-templates>
	</xsl:template>
	
	
	<xsl:template match="ROW">
		<!--xsl:variable name="nroFila"> 
		       <xsl:value-of select="position()" /> 
		</xsl:variable--> 
		<tr height="20px">
			<td class="datosCamposCenterImpar" align="middle">
				<xsl:element name="label">
					<!--xsl:attribute name="name">labelCTitulo<xsl:value-of select="$nroFila" />
</xsl:attribute-->
					<xsl:attribute name="height">20</xsl:attribute>
					<xsl:attribute name="width">567</xsl:attribute>
					<xsl:attribute name="style">text-align:center</xsl:attribute>
						<xsl:value-of select="CAMPO[@NOMBRE='nombrefuncion']" />
				</xsl:element>
			</td>
			<td  class="datosCamposCenterPar" align="middle">
				<!--todo: S/N -->
				<!--input type="checkbox"	name="_{CAMPO[@NOMBRE='idfuncion']}"-->
				<input type="checkbox">
					<xsl:attribute name="id">_<xsl:value-of select="CAMPO[@NOMBRE='idfuncion']"/></xsl:attribute>
					<xsl:attribute name="onclick">
						<xsl:text disable-output-escaping="yes">checkAsignar('_</xsl:text><xsl:value-of 
select="CAMPO[@NOMBRE='idfuncion']"/><xsl:text disable-output-escaping="yes">')</xsl:text>
					</xsl:attribute>
				</input>
			</td>
			<td class="datosCamposCenterImpar" align="middle">
				<!--input type="checkbox"	name="_{CAMPO[@NOMBRE='idfuncion']}_sel"-->
				<input type="checkbox">
					<xsl:attribute name="id">_<xsl:value-of select="CAMPO[@NOMBRE='idfuncion']"/>_sel</xsl:attribute>
					<xsl:attribute name="onclick">
						<xsl:text disable-output-escaping="yes">checkInicio('_</xsl:text><xsl:value-of 
select="CAMPO[@NOMBRE='idfuncion']"/><xsl:text disable-output-escaping="yes">')</xsl:text>
					</xsl:attribute>
				</input>
			</td>
		</tr>		
	</xsl:template>
</xsl:stylesheet>
