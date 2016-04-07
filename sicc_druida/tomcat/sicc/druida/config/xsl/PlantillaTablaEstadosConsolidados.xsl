<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>
	<!--xsl:output indent="yes" omit-xml-declaration="no" encoding="UTF-8" method="xml"/-->
	<!--xsl:key name="condiciones" match="ROW" use="CAMPO[@NOMBRE='NUM_COND'][position()=1]"/-->
	<xsl:template match="ROWSET">
		<!--table width="597" border="0" cellspacing="0" cellpadding="0"  align="center">
    <tr> 
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
    </tr>
    <tr>      
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
      <td-->
		<table width="582" border="1" cellspacing="0" cellpadding="0" bordercolor="#CCCCCC">
			<TR align="center">
				<TD class="tablaTitle">
					<IMG src="b.gif" width="100" height="12"/>
				</TD>
				<TD class="tablaTitle">
					<IMG src="b.gif" width="80" height="12"/>
				</TD>
				<TD class="tablaTitle">
					<IMG src="b.gif" width="8" height="22"/>
				</TD>
				<TD colspan="2" class="tablaTitle">GP 1</TD>
				<TD colspan="2" class="tablaTitle">GP 2</TD>
				<TD colspan="2" class="tablaTitle">GP 3</TD>
				<TD colspan="2" class="tablaTitle">GP 4</TD>
				<TD colspan="2" class="tablaTitle">GP 5</TD>
			</TR>
			<TR>
				<!--TD class="tablaTitle">
				<IMG src="b.gif" witdh="8" height="8"/>
			</TD-->
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabClase" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="2228"/>
				</td>
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabRegion" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="155"/>
				</td>
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabZona" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="156"/>
				</td>
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabSecue1" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1039"/>
				</td>
				<td class="tablaTitle" width="50">
					<LABELC nombre="lblTabTotal1" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1038"/>
				</td>
				<td class="tablaTitle" width="60">
					<LABELC nombre="lblTabSecue2" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1039"/>
				</td>
				<td class="tablaTitle" width="50">
					<LABELC nombre="lblTabTotal2" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1038"/>
				</td>
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabSecue3" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1039"/>
				</td>
				<td class="tablaTitle" width="50">
					<LABELC nombre="lblTabTotal3" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1038"/>
				</td>
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabSecue4" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1039"/>
				</td>
				<td class="tablaTitle" width="50">
					<LABELC nombre="lblTabTotal4" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1038"/>
				</td>
				<td class="tablaTitle" width="80">
					<LABELC nombre="lblTabSecue5" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1039"/>
				</td>
				<td class="tablaTitle" width="50">
					<LABELC nombre="lblTabTotal5" alto="22" ancho="80" filas="1" id="datosCamposCabecera" cod="1038"/>
				</td>
			</TR>
			<xsl:for-each select="ROW">
				<!--xsl:variable name="numero"> 
			<xsl:number/>
		</xsl:variable-->
				<!--xsl:variable name="numero" select="0"/-->
				<tr>
					<td align="center" class="datosCamposCenterImpar">
						<xsl:value-of select="CAMPO[@NOMBRE='CLASE']"/>
					</td>
					<td align="center"   class="datosCamposCenterPar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='REGION']"/>
					</td>
					<td align="center" class="datosCamposCenterImpar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='ZONA']"/>
					</td>
					<td align="center"  class="datosCamposCenterPar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:if test="not (CAMPO[@NOMBRE='IDENTIF']=-1)">
							<CTEXTO nombre="txtSecGP1_{CAMPO[@NOMBRE='IDENTIF']}" class="datosCampos" tipo="" onchange="" req="N" size="1" max="2" valor="{CAMPO[@NOMBRE='IDENTIF']}" validacion="" onshtab="onshTabGP1({CAMPO[@NOMBRE='IDENTIF']});" ontab="onTabGP1({CAMPO[@NOMBRE='IDENTIF']});"/>
						</xsl:if>
					</td>
					<td align="right " class="datosCamposRightImpar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='GP1']"/>
					</td>
					<td align="center"  class="datosCamposCenterPar">

						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>

						<xsl:if test="not (CAMPO[@NOMBRE='IDENTIF']=-1)">
							<CTEXTO nombre="txtSecGP2_{CAMPO[@NOMBRE='IDENTIF']}" class="datosCampos" tipo="" onchange="" req="N" size="1" max="2" valor="{CAMPO[@NOMBRE='IDENTIF']}" validacion=""  onshtab="onshTabGP2({CAMPO[@NOMBRE='IDENTIF']});" ontab="onTabGP2({CAMPO[@NOMBRE='IDENTIF']});" />
						</xsl:if>
					</td>
					<td align="right" class="datosCamposRightImpar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='GP2']"/>
					</td>
					<td align="center"   class="datosCamposCenterPar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:if test="not (CAMPO[@NOMBRE='IDENTIF']=-1)">
							<CTEXTO nombre="txtSecGP3_{CAMPO[@NOMBRE='IDENTIF']}" class="datosCampos" tipo="" onchange="" req="N" size="1" max="2" valor="{CAMPO[@NOMBRE='IDENTIF']}" validacion=""  onshtab="onshTabGP3({CAMPO[@NOMBRE='IDENTIF']});" ontab="onTabGP3({CAMPO[@NOMBRE='IDENTIF']});" />
						</xsl:if>
					</td>
					<td align="right" class="datosCamposRightImpar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='GP3']"/>
					</td>
					<td align="center"  class="datosCamposCenterPar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:if test="not (CAMPO[@NOMBRE='IDENTIF']=-1)">
							<CTEXTO nombre="txtSecGP4_{CAMPO[@NOMBRE='IDENTIF']}" class="datosCampos" tipo="" onchange="" req="N" size="1" max="2" valor="{CAMPO[@NOMBRE='IDENTIF']}" validacion=""  onshtab="onshTabGP4({CAMPO[@NOMBRE='IDENTIF']});" ontab="onTabGP4({CAMPO[@NOMBRE='IDENTIF']});" />
						</xsl:if>
					</td>
					<td align="right" class="datosCamposRightImpar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='GP4']"/>
					</td>
					<td align="center"   class="datosCamposCenterPar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:if test="not (CAMPO[@NOMBRE='IDENTIF']=-1)">
							<CTEXTO nombre="txtSecGP5_{CAMPO[@NOMBRE='IDENTIF']}" class="datosCampos" tipo="" onchange="" req="N" size="1" max="2" valor="{CAMPO[@NOMBRE='IDENTIF']}" validacion=""  onshtab="onshTabGP5({CAMPO[@NOMBRE='IDENTIF']});" ontab="onTabGP5({CAMPO[@NOMBRE='IDENTIF']});" />
						</xsl:if>
					</td>
					<td align="right" class="datosCamposRightImpar">
						<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
							<IMG src="b.gif" width="12" height="12"/>
						</xsl:if>
						<xsl:value-of select="CAMPO[@NOMBRE='GP5']"/>
					</td>
				</tr>
				<xsl:if test="CAMPO[@NOMBRE='CLASE']='Total'">
					<tr>
						<td width="12" align="center" colspan="13">
							<IMG src="b.gif" width="12" height="12"/>
						</td>
					</tr>
				</xsl:if>
				<VAR valor="{CAMPO[@NOMBRE='IDENTIF']}" nombre="hidIden_{position()}"/>
				<xsl:if test="position()=last()">
					<tr>
						<td>
							<VAR valor="{position()}" nombre="hidCantFilas"/>
						</td>
					</tr>
				</xsl:if>
				<xsl:if test="not (CAMPO[@NOMBRE='IDENTIF']=-1)">
					<VAR valor="{CAMPO[@NOMBRE='ZONA']}" nombre="hidZona_{CAMPO[@NOMBRE='IDENTIF']}"/>
					<VAR valor="{CAMPO[@NOMBRE='REGION']}" nombre="hidRegion_{CAMPO[@NOMBRE='IDENTIF']}"/>
					<VAR valor="" nombre="hidClase_{position()}"/>
				</xsl:if>
				<xsl:if test="CAMPO[@NOMBRE='IDENTIF']=-1">
					<xsl:if test="CAMPO[@NOMBRE='GP1']=''">
						<VAR valor="{CAMPO[@NOMBRE='CLASE']}" nombre="hidClase_{position()}"/>
					</xsl:if>
					<xsl:if test="not (CAMPO[@NOMBRE='GP1']='')">
						<VAR valor="" nombre="hidClase_{position()}"/>
					</xsl:if>
				</xsl:if>
			</xsl:for-each>
		</table>
		<!--/td>
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
    </tr>
    <tr> 
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
    </tr>
  </table-->
	</xsl:template>
</xsl:stylesheet>
