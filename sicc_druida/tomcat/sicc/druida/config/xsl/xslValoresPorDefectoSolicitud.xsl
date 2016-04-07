<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/> 
	<xsl:template match="//ROWSET2">
		<table width="1320" border="1" cellspacing="0" cellpadding="0" bordercolor="#CCCCCC">
			<xsl:apply-templates select="ROWSET"/>
		</table>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:choose>
			<xsl:when test="./@ID='dtoSalida.lista2_ROWSET'">
				<xsl:apply-templates select="ROW">
					<!--xsl:sort select="CAMPO[@NOMBRE='nombrefuncion']"></xsl:sort-->
				</xsl:apply-templates>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template match="ROW">
		<tr>
			<td class="datosCamposCenterImpar" width="430"  >
				<VAR valor="{CAMPO[@NOMBRE='PAIS_COD_PAIS']}|{CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI']}|{CAMPO[@NOMBRE='ATRE_CAMP']}|{CAMPO[@NOMBRE='ATRE_MODU']}" nombre="hidIden_{position()}"/>
					<xsl:value-of select="CAMPO[@NOMBRE='DES_TIPO_SOLI']" disable-output-escaping="yes"/>
			</td>
			<td  class="datosCamposCenterPar" width="310" >
				<xsl:value-of select="CAMPO[@NOMBRE='DES_ATRI']" disable-output-escaping="yes"/>				
			</td>
			<td class="datosCamposCenterImpar" width="310" >
					<CTEXTO nombre="VALO_DEFE_{position()}" class="datosCampos" id="" max="30" tipo="" onchange="" req="N" size="30" valor="{CAMPO[@NOMBRE='VALO_DEFE']}" validacion="" onshtab="onshTabText({position()});" ontab="onTabText({position()});"/>
			</td>
			<td class="datosCamposCenterPar" width="130" >
				<CHECKBOX onfocus="" onclick="" id="" req="N" validacion="" check="N" texto="" nombre="IND_INSE_OBLI_{position()}" ontab="onTabCheck1({position()});" onshtab="onshTabCheck1({position()});">
					<xsl:if test="CAMPO[@NOMBRE='IND_INSE_OBLI']='S'">
						<xsl:attribute name="check">S</xsl:attribute>
					</xsl:if>
				</CHECKBOX>
			</td>
			<td class="datosCamposCenterImpar" width="130">
				<CHECKBOX onfocus="" onclick="" id="" req="N" validacion="" check="N" texto="" nombre="IND_MODI_PERM_{position()}" ontab="onTabCheck2({position()});" onshtab="onshTabCheck2({position()});" >
					<xsl:if test="CAMPO[@NOMBRE='IND_MODI_PERM']='S'">
						<xsl:attribute name="check">S</xsl:attribute>
					</xsl:if>
				</CHECKBOX>
			</td>
		</tr>
		<xsl:if test="position()=last()">
			<VAR valor="{position()}" nombre="hidCantFilas"/>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>

