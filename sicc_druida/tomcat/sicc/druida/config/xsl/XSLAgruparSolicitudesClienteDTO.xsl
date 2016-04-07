<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output indent="yes" omit-xml-declaration="no" encoding="ISO-8859-1" method="xml"/>

<xsl:key name="condiciones" match="ROW" use="CAMPO[@NOMBRE='CLIE_COD_CLIE']"/>
<xsl:key name="solicitudes" match="ROW" use="concat(CAMPO[@NOMBRE='NUM_SOLI'],CAMPO[@NOMBRE='CLIE_COD_CLIE']) "/>



<xsl:variable name="campoDescripcion">250</xsl:variable>
<xsl:variable name="campoCantidad">100</xsl:variable>
<xsl:variable name="campoPrecioUnidad">100</xsl:variable>
<xsl:variable name="campoValorTotal">100</xsl:variable>
<xsl:variable name="campoDescuento">100</xsl:variable>
<xsl:variable name="anchoTotal"><xsl:value-of select="number($campoDescripcion)+number($campoCantidad)+number($campoPrecioUnidad)+number($campoValorTotal)+number($campoDescuento)"/></xsl:variable>
<xsl:variable name="labelCliente">100</xsl:variable>
<xsl:variable name="labelDescripcionCliente"><xsl:value-of select="number($anchoTotal)-number(number($labelCliente)+number(8))"/></xsl:variable>


<xsl:template match="//ROWSET2">
	<table cellpadding="0" cellspacing="0" border="0" width="{$anchoTotal}">
		<xsl:apply-templates select="ROWSET"></xsl:apply-templates>
	</table>
</xsl:template>

<xsl:template match="ROWSET">
	<!--Agrupo por Cliente-->
	<xsl:for-each select="ROW[count(. | key('condiciones',CAMPO[@NOMBRE='CLIE_COD_CLIE'])[1])=1]">
		<xsl:sort select="CAMPO[@NOMBRE='NOM1']"/>
		<xsl:sort select="CAMPO[@NOMBRE='NOM2']"/>
		<xsl:sort select="CAMPO[@NOMBRE='APE1']"/>
		<xsl:sort select="CAMPO[@NOMBRE='APE2']"/>
		<xsl:variable name="actual" ><xsl:value-of select="CAMPO[@NOMBRE='CLIE_COD_CLIE']"/></xsl:variable>
		<tr>
			<td style="border-bottom:none">
				<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#cccccc">
					<tr>
						<td width="{$labelCliente}" style="border-right:none;">
							<LABELC nombre="lblCliente_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="{$labelCliente}" id="datosTitle" filas="1" cod="2049"/>
						</td>
						<td style="border-right:none;border-left:none"><IMG src="transparente.gif" width="8px"/></td>
						<td width="100%" style="border-left:none"><label id="datosCamposLeft"><xsl:value-of select="CAMPO[@NOMBRE='NOM1']" disable-output-escaping="yes"/><xsl:text> </xsl:text><xsl:value-of select="CAMPO[@NOMBRE='NOM2']" disable-output-escaping="yes"/><xsl:text> </xsl:text><xsl:value-of select="CAMPO[@NOMBRE='APE1']" disable-output-escaping="yes"/><xsl:text> </xsl:text><xsl:value-of select="CAMPO[@NOMBRE='APE2']" disable-output-escaping="yes"/></label></td>
					</tr>
				</table>
			</td>
		</tr>
		<xsl:variable name="cliente" select="//ROW[CAMPO[@NOMBRE='CLIE_COD_CLIE']=$actual]"/>
		<xsl:for-each select="$cliente[count(. | key('solicitudes',concat(CAMPO[@NOMBRE='NUM_SOLI'],CAMPO[@NOMBRE='CLIE_COD_CLIE']) )[1])=1]">
			<xsl:variable name="solicitud"><xsl:value-of select="CAMPO[@NOMBRE='NUM_SOLI']"/></xsl:variable>
			<tr>
				<td >
					<table width="{$anchoTotal}" cellpadding="0" cellspacing="0" border="1" bordercolor="#CCCCCC" name="tblSolicitud_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}_{CAMPO[@NOMBRE='NUM_SOLI']}">
						<tr>
							<td style="background-color:#cccccc;text-align:left" colspan="5" id="datosTitle">
								<table width="880" border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td width="80">
												<LABELC nombre="lblSolicitud_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="80" id="datosTitle" filas="1" cod="850"/>
											</td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="30" class="datosTitleLeft" ><xsl:value-of select="CAMPO[@NOMBRE='NUM_SOLI']"/></td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="150">
												<LABELC nombre="lblCampSol_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="150" id="datosTitle" filas="1" cod="882"/>
											</td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="210" class="datosTitleLeft"><xsl:value-of select="CAMPO[@NOMBRE='NOM_PERI']"/></td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="120">
												<LABELC nombre="lblFechaSol_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="120" id="datosTitle" filas="1" cod="883"/>
											</td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="80" class="datosTitleLeft"><xsl:value-of select="CAMPO[@NOMBRE='FECH_FACTU']"/></td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="80">
												<LABELC nombre="lbl_MontoSol{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="80" id="datosTitle" filas="1" cod="592"/>
											</td>
											<td><IMG src="transparente.gif" width="8px"/></td>
											<td width="80" class="datosTitleLeft" ><label name="lblMontoSol_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}"><xsl:value-of select="CAMPO[@NOMBRE='IMP_TOTA_DESC']"/></label></td>
										</tr>
								</table>
							</td>
						</tr>
						<tr id="fondoCabecera">
							<td width="{$campoDescripcion}">
								<LABELC nombre="lbl_Descrip_a_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="{$campoDescripcion}" id="datosTitleCenter" filas="1" cod="2215"/>
							</td>
							<td width="{$campoCantidad}">
								<LABELC nombre="lbl_Descrip_b_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="{$campoCantidad}" id="datosTitleCenter" filas="1" cod="594"/>
							</td>
							<td width="{$campoPrecioUnidad}">
								<LABELC nombre="lbl_Descrip_c_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="{$campoPrecioUnidad}" id="datosTitleCenter" filas="1" cod="187"/>
							</td>
							<td width="{$campoValorTotal}">
								<LABELC nombre="lbl_Descrip_d_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="{$campoValorTotal}" id="datosTitleCenter" filas="1" cod="513"/>
							</td>
							<td width="{$campoDescuento}">
								<LABELC nombre="lbl_Descrip_e_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}" alto="30" ancho="{$campoDescuento}" id="datosTitleCenter" filas="1" cod="595"/>
							</td>
						</tr>
						<xsl:apply-templates select="//ROW[CAMPO[@NOMBRE='CLIE_COD_CLIE']=$actual and CAMPO[@NOMBRE='NUM_SOLI']=$solicitud]">
							<xsl:sort select="CAMPO[NUM_POSI]"/>
						</xsl:apply-templates>
					</table>
				</td>
			</tr>
		</xsl:for-each>
		<tr>
			<td colspan="3"><IMG src="transparente.gif" width="8px"/></td>
		</tr>
		<tr>
			<td colspan="3"><IMG src="transparente.gif" width="8px"/></td>
		</tr>

	</xsl:for-each>
</xsl:template>

<xsl:template match="ROW">
	<tr height="30">
		<td height="30" id="datosCamposCenterImpar" style="border:right:3px solid #CCCCCC"><IMG src="transparente.gif" width="1" height="1"/><xsl:value-of select="CAMPO[@NOMBRE='DES_SAP']"/></td>
		<td id="datosCamposRightPar"  style="border:none">
			<input type="text" maxlength="10" style=" text-align:right;width:98%;background-color:white;height:18" id="datosCamposRightPar" onchange="fnChange('{CAMPO[@NOMBRE='CLIE_COD_CLIE']}','{CAMPO[@NOMBRE='NUM_SOLI']}','{CAMPO[@NOMBRE='NUM_POSI']}')" value="{CAMPO[@NOMBRE='NUM_UNID_POR_ATEN']}" name="txtUnidades_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}_{CAMPO[@NOMBRE='NUM_POSI']}"></input>
		</td>
		<td id="datosCamposRightImpar" style="border:none"><IMG src="transparente.gif" width="1" height="1"/><xsl:value-of select="CAMPO[@NOMBRE='PREC_CATA']"/></td>
		<td id="datosCamposRightPar" style="border:none"><IMG src="transparente.gif" width="1" height="1"/>
			<label id="lblTotal_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}_{CAMPO[@NOMBRE='NUM_POSI']}">
				<xsl:choose>
					<xsl:when test="string(number(CAMPO[@NOMBRE='PREC_CATA']) + number(CAMPO[@NOMBRE='NUM_UNID_POR_ATEN'])) != 'NaN' ">
						<xsl:value-of select="number(CAMPO[@NOMBRE='NUM_UNID_POR_ATEN'])*number(CAMPO[@NOMBRE='PREC_CATA'])"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>0</xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</label></td>
		<td id="datosCamposRightImpar" style="border:left:3px solid #CCCCCC">
			<label name="lblDescuento_{CAMPO[@NOMBRE='NUM_SOLI']}_{CAMPO[@NOMBRE='CLIE_COD_CLIE']}_{CAMPO[@NOMBRE='NUM_POSI']}">
				<xsl:choose>
					<xsl:when test="string(number(CAMPO[@NOMBRE='MONT_DESC'])+number(CAMPO[@NOMBRE='PREC_DESC'])) = 'NaN'">
						<xsl:text>0</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="number(CAMPO[@NOMBRE='MONT_DESC'])+number(CAMPO[@NOMBRE='PREC_DESC'])"/><xsl:text></xsl:text>	
					</xsl:otherwise>
				</xsl:choose>
			</label>
		</td>
	</tr>
</xsl:template>

</xsl:stylesheet>