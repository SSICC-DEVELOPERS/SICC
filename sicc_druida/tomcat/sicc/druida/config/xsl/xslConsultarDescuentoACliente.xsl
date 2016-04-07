<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" indent="yes" method="xml"
		omit-xml-declaration="no" version="1.0"/>
	<xsl:key match="ROW" name="condiciones" use="concat(CAMPO[1],'__',CAMPO[2],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[5], '__',CAMPO[6], '__',CAMPO[7])"/>
	<xsl:template match="//ROWSET2">
		<table align="center" border="0" cellpadding="0" cellspacing="0" width="597">
			<tr>
				<td align="center" width="12">
					<IMG height="12" src="b.gif" width="12"/>
				</td>
				<td>
					<table border="0" bordercolor="#CCCCCC" cellpadding="0"
						cellspacing="1" width="582">
						<tr>
							<td > <LABELC alto="25"
									ancho="170" cod="617" filas="1"
									id="datosTitle" nombre="lblPrincNombre"/>
							</td>
							<td>
								<IMG height="8" src="b.gif" width="1"/>
							</td>
							<xsl:variable name="nombre" select="//CAMPO[@NOMBRE='NOMBRE']"/>
							<td >
								<LABELC alto="25" ancho="100" 
									filas="1" id="datosCamposLeft"
									nombre="lblPrincNombre2" valor="{$nombre}"/>
							</td>
						</tr>
						<tr>
							<td ><LABELC alto="25"
									ancho="170" cod="781" filas="1"
									id="datosTitle" nombre="lblPrincApe"/>
							</td>
							<td>
								<IMG height="8" src="b.gif" width="1"/>
							</td>
							<xsl:variable name="Apellido" select="//CAMPO[@NOMBRE='APELLIDO']"/>
							<td >
								<LABELC alto="25" ancho="100" 
									filas="1" id="datosCamposLeft"
									nombre="lblPrincApe2" valor="{$Apellido}"/>
							</td>
						</tr>
						<tr>
							<td ><LABELC
									alto="25" ancho="170" cod="267" filas="1"
									id="datosTitle" nombre="lblPrincTC"/>
							</td>
							<td>
								<IMG height="8" src="b.gif" width="1"/>
							</td>
							<xsl:variable name="tClient" select="//CAMPO[@NOMBRE='TIPO_CLIENTE']"/>
							<td >
								<LABELC alto="25" ancho="100" 
									filas="1" id="datosCamposLeft"
									nombre="lblPrincTC2" valor="{$tClient}"/>
							</td>
							<td > <LABELC
									alto="25" ancho="170" cod="273" filas="1"
									id="datosTitle" nombre="lblPrincSTC"/>
							</td>
							<td>
								<IMG height="8" src="b.gif" width="1"/>
							</td>
							<xsl:variable name="stClient" select="//CAMPO[@NOMBRE='SUBTIPO_CLIENTE']"/>
							<td >
								<LABELC alto="25" ancho="100" 
									filas="1" id="datosCamposLeft"
									nombre="lblPrincSTC2" valor="{$stClient}"/>
							</td>
						</tr>
						<tr>
							<td ><LABELC
									alto="25" ancho="170" cod="655" filas="1"
									id="datosTitle" nombre="lblPrincTClas"/>
							</td>
							<td>
								<IMG height="8" src="b.gif" width="1"/>
							</td>
							<xsl:variable name="tipClasif" select="//CAMPO[@NOMBRE='TIPO_CLASIFICACION']"/>
							<td >
								<LABELC alto="25" ancho="100" 
									filas="1" id="datosCamposLeft"
									nombre="lblPrincTClas2" valor="{$tipClasif}"/>
							</td>
							<td ><LABELC
									alto="25" ancho="170" cod="458" filas="1"
									id="datosTitle" nombre="lblPrincClasif"/>
							</td>
							<td>
								<IMG height="8" src="b.gif" width="1"/>
							</td>
							<xsl:variable name="clasif" select="//CAMPO[@NOMBRE='CLASIFICACION']"/>
							<td >
								<LABELC alto="25" ancho="100" 
									filas="1" id="datosCamposLeft"
									nombre="lblPrincClasif2" valor="{$clasif}"/>
							</td>
						</tr>
						<tr>
							<td>
								<IMG height="8" src="b.gif" width="12"/>
							</td>
						</tr>
						<tr>
							<td colspan="7">
								<xsl:apply-templates select="//ROWSET[@ID='dtoSalida.resultado_ROWSET']"/>
							</td>
						</tr>

					</table>
				</td>
				<td align="center" width="12">
					<IMG height="12" src="b.gif" width="12"/>
				</td>
			</tr>
			<tr>
				<td align="center" width="12">
					<IMG height="12" src="b.gif" width="12"/>
				</td>
				<td>
					<IMG height="12" src="b.gif" width="12"/>
				</td>
				<td>
					<IMG height="12" src="b.gif" width="12"/>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:for-each select="ROW[count(. | key('condiciones',concat(CAMPO[1],'__',CAMPO[2],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[5], '__',CAMPO[6], '__',CAMPO[7]))[1])=1]">
			<xsl:sort select="CAMPO[@NOMBRE='NUM_SOLI']"/>
			<!--
		ak se arma el header de las tablas, es decir, el agrupado
		-->
			<table align="center" border="0" bordercolor="#CCCCCC"
				cellpadding="0" cellspacing="1" width="99%">
				<tr>
					<td>
						<table align="center" border="0" cellpadding="0"
							cellspacing="0" width="98%">
							<tr>
								<td class="tablaTitle" colspan="6">
									<table align="center" border="0"
										cellpadding="0" cellspacing="0" width="98%">
										<tr>
										<xsl:variable name="solic" select="CAMPO[@NOMBRE='SOLICITUD']"/>
										<td width="80" class="fondoCabecera"><LABELC alto="25"
										ancho="80" cod="850"
										filas="1"
										id="datosTitle" nombre="lblPrincSolic{CAMPO[@NOMBRE='NUM_SOLI']}"/>
										</td>
										<td class="datosCamposCabecera" width="8">
										<IMG height="8" src="b.gif" width="8"/>
										</td>
										<td class="fondoCabecera" width="250">
										<LABELC alto="25" ancho="250" filas="1"
										id="datosTitleLeft"
										nombre="lblSolic{CAMPO[@NOMBRE='NUM_SOLI']}" valor="{$solic}"/>
										</td>
										<td width="80%">
										<IMG height="8" src="b.gif" width="8"/></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td width="33px"><LABELC alto="30"
										ancho="133" cod="869" filas="1"
										id="datosTitle" nombre="lblNumCond_{CAMPO[@NOMBRE='NUM_SOLI']}"/>
								</td>
								<td width="8">
									<IMG height="8" src="b.gif" width="8"/>
								</td>
								<td class="datosCamposLeft">
									<xsl:value-of select="CAMPO[@NOMBRE='NUM_SOLI']"/>
								</td>
								<td width="33px"><LABELC alto="30"
										ancho="133" cod="591" filas="1"
										id="datosTitle" nombre="lblFechaSol_{CAMPO[@NOMBRE='NUM_SOLI']}"/>
								</td>
								<td width="8">
									<IMG height="8" src="b.gif" width="8"/>
								</td>
								<td class="datosCamposLeft">
									<xsl:value-of select="CAMPO[@NOMBRE='FECHA']"/>
								</td>
							</tr>
							<tr>
								<td width="33px"><LABELC alto="30"
										ancho="133" cod="592" filas="1"
										id="datosTitle" nombre="lblMontTotalSol_{CAMPO[@NOMBRE='NUM_SOLI']}"/>
								</td>
								<td width="8">
									<IMG height="8" src="b.gif" width="8"/>
								</td>
								<td class="datosCamposLeft">
									<xsl:value-of select="CAMPO[@NOMBRE='MONTO_TOTAL']"/>
								</td>
								<td width="33px"><LABELC
										alto="30" ancho="133" cod="870"
										filas="1" id="datosTitle" nombre="lblDescTotal_{CAMPO[@NOMBRE='NUM_SOLI']}"/>
								</td>
								<td width="8">
									<IMG height="8" src="b.gif" width="8"/>
								</td>
								<td class="datosCamposLeft" width="133px">
									<xsl:value-of select="CAMPO[@NOMBRE='DESCUENTO_TOTAL']"/>
								</td>
							</tr>
							<xsl:apply-templates select="."/>
							<!--
			Ahora va el Pie de la Tabla
		-->
							<tr>
								<td class="datosCampos" colspan="3">
									<IMG height="8" src="b.gif" width="8"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="datosCampos" style="border:none">
						<IMG height="8" src="b.gif" width="8"/>
					</td>
				</tr>
			</table>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="ROW">
		<!--
		ak se arman los detalles, es decir, lo que serian las listas internas,
		El detalle del grupo, incluido el nodo que se uso para agrupar
	-->
		<tr>
			<td colspan="6" height="151" valign="top">
				<LISTA accion="" alto="150" ancho="560" blockImg="" chkcolor=""
					colorborde="#CCCCCC" colorf="#EFEFEF" entradax=""
					entraday="" imagenoff="close_no.gif" imagenon="close_up.gif"
					incx="10" incy="10" multisel="0" nmax="-1" nmin=""
					nombre="lstResultados_{CAMPO[@NOMBRE='NUM_SOLI']}"
					onSetDatos="" oncolor="" pixelsborde="2" seleccion="boton"
					sep="|" visibilidad="" x="" y="">
					<CABECERA height="30" nombre="cab1">
						<COL ancho="200" id="fondoCabecera">
							<LABELC alto="30" ancho="200" cod="43"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblCodigo_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="200" id="fondoCabecera">
							<LABELC alto="30" ancho="200" cod="28"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblDesc_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="90" id="fondoCabecera">
							<LABELC alto="30" ancho="90" cod="796"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblUni_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="120" id="fondoCabecera">
							<LABELC alto="30" ancho="120" cod="892"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblBaseCalculo_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="100" id="fondoCabecera">
							<LABELC alto="30" ancho="100" cod="893"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblPorcentDesc_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="100" id="fondoCabecera">
							<LABELC alto="30" ancho="100" cod="894"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblDescAplic_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="100" id="fondoCabecera">
							<LABELC alto="30" ancho="100" cod="895"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblAplicarse_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="100" id="fondoCabecera">
							<LABELC alto="30" ancho="100" cod="896"
								enviaroculto="N" filas="1"
								id="datosCamposCabecera"
								nombre="lblFechaDescuento_{CAMPO[@NOMBRE='NUM_SOLI']}" valor=""/>
						</COL>
						<COL ancho="20" id="fondoCabecera"/>
					</CABECERA>
					<PRESENTACION ancho="1000"
						bloquesid="['datosCamposRightImpar', 'datosCamposCenterPar', 
						'datosCamposRightImpar','datosCamposRightPar',
						'datosCamposRightImpar','datosCamposRightPar',
						'datosCamposCenterImpar','datosCamposCenterPar']">
						<COL ancho="200" caracteres="20"/>
						<COL ancho="200" caracteres="50"/>
						<COL ancho="90" caracteres="12"/>
						<COL ancho="120" caracteres="50"/>
						<COL ancho="100" caracteres="50"/>
						<COL ancho="100" caracteres="50"/>
						<COL ancho="100" caracteres="50"/>
						<COL ancho="100" caracteres="50"/>
					</PRESENTACION>
					<ROWSET>
						<xsl:for-each select="key('condiciones', concat(CAMPO[1],'__',CAMPO[2],'__',CAMPO[3],'__',CAMPO[4],'__',CAMPO[5], '__',CAMPO[6], '__',CAMPO[7]))">
							<xsl:sort select="CAMPO[@NOMBRE='DES_CATA']"/>
							<ROW>
								<CAMPO NOBRE="codigo" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=20]"/>
								</CAMPO>
								<CAMPO NOBRE="desc" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=21]"/>
								</CAMPO>
								<CAMPO NOBRE="unidad" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=22]"/>
								</CAMPO>
								<CAMPO NOBRE="baseC" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=23]"/>
								</CAMPO>
								<CAMPO NOBRE="porDesc" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=24]"/>
								</CAMPO>
								<CAMPO NOBRE="descAplic" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=25]"/>
								</CAMPO>
								<CAMPO NOBRE="aplicarse" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=26]"/>
								</CAMPO>
								<CAMPO NOBRE="fechadescuento" TIPO="STRING">
									<xsl:value-of select="CAMPO[position()=27]"/>
								</CAMPO>
							</ROW>
						</xsl:for-each>
					</ROWSET>
				</LISTA>
			</td>
		</tr>

	</xsl:template>
</xsl:stylesheet>