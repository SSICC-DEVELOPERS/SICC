<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" version="1.0" indent="yes"/>
	<xsl:variable name="perfil" select="//ROWSET[@ID='Row_perfil']"/>
	<xsl:template match="//ROWSET2">
		<TABLA nombre="tblFunciones" width="561" cellpadding="0" cellspacing="0" align="right" border="0">
			<xsl:apply-templates select="./ROWSET[@ID='Row_Funciones']"/>
		</TABLA>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:apply-templates select="./ROW">
			<xsl:sort select="CAMPO[@NOMBRE='nombre']"/>
		</xsl:apply-templates>
	</xsl:template>


	<xsl:template match="ROW">
		<xsl:variable name="asociado"  select="$perfil/ROW[CAMPO[@NOMBRE='id']=current()/CAMPO[@NOMBRE='idfuncion']]"/>
		<TR height="24">
			<TD width="340" id="datosCamposCenterImpar" height="24">
				<xsl:value-of disable-output-escaping="yes" select="./CAMPO[@NOMBRE='nombrefuncion']"/>
			</TD>
			<TD width="122" id="datosCamposCenterPar" valign="middle" >
				<CHECKBOX nombre="{./CAMPO[@NOMBRE='idfuncion']}" onclick="checkAsignar('{./CAMPO[@NOMBRE='idfuncion']}')">
					<xsl:attribute name="check">
						<xsl:choose>
							<xsl:when test="$asociado">S</xsl:when>
							<xsl:otherwise>N</xsl:otherwise>
						</xsl:choose>
					</xsl:attribute>
				</CHECKBOX>
			</TD>
			<TD width="110" id="datosCamposCenterImpar" valign="middle" >
				<CHECKBOX nombre="{./CAMPO[@NOMBRE='idfuncion']}_sel" onclick="checkInicio('{./CAMPO[@NOMBRE='idfuncion']}')">
					<xsl:attribute name="check">
						<xsl:choose>
							<xsl:when test="$asociado/CAMPO[@NOMBRE='inicio']!=0">S</xsl:when>
							<xsl:otherwise>N</xsl:otherwise>
						</xsl:choose>
					</xsl:attribute>
				</CHECKBOX>
			</TD>
		</TR>
	</xsl:template>
</xsl:stylesheet>