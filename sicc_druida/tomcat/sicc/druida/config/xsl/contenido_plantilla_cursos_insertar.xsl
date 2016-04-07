<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

         <xsl:output encoding="ISO-8859-1" method="xml" indent="yes"/>

	<xsl:template match="/">
			<xsl:apply-templates/>
	</xsl:template>

	<xsl:template match="ROWSET2">
		<CAPA nombre="capaPromocion">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="12" align="center">
						<IMG src="b.gif" width="12" height="12"/>
					</td>
					<td width="750">
						<IMG src="b.gif"/>
					</td>
					<td width="12">
						<IMG src="b.gif" width="12" height="1"/>
					</td>
				</tr>
				<!--**************************-->
				<tr>
					<td>
						<IMG src="b.gif"/>
					</td>
					<td>
						<fieldset>
							<legend class="legend">
								<LABELC nombre="lblDatosGenerales" alto="13" filas="1" valor="" id="legend" cod="0011"/>
							</legend>
							<table width="100%" border="0" align="center" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="4">
										<IMG src="b.gif" width="8" height="8"/>
									</td>
								</tr>
								<tr>
									<td>
										<IMG src="b.gif" width="8" height="8"/>
									</td>
									<td>
										<LABELC nombre="lblNombrePlantilla" alto="13" filas="1" valor="" id="datosTitle" cod="743"/>
									</td>
									<td width="100%">
										<IMG src="b.gif" width="8" height="8"/>
									</td>
								</tr>
								<tr>
									<td>
										<IMG src="b.gif" width="8" height="8"/>
									</td>
									<td nowrap="nowrap">
										<TEXT nombre="txtNombrePlantilla" id="datosCampos" max="75" tipo="" onchange="" req="S" size="75" valor="" validacion="" onshtab="irAUltimo()" readonly="N"/>
										<IMG src="iconmultidioma.gif" width="21" height="15" onclick="levantarI18N('frmInsertarPlantilla', '1');"/>
									</td>
									<td width="100%">
										<IMG src="b.gif" width="8" height="12"/>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<IMG src="b.gif" width="8" height="8"/>
									</td>
								</tr>
							</table>
							<xsl:apply-templates select="ROWSET[@ID='DTOCargaCursos.parametros']"/>
						</fieldset>
					</td>
					<td>
						<IMG src="b.gif" width="12" height="12"/>
					</td>
				</tr>
				<tr>
					<td width="12" align="center">
						<IMG src="b.gif" width="12" height="12"/>
					</td>
					<td width="750">
						<IMG src="b.gif"/>
					</td>
					<td width="12">
						<IMG src="b.gif" width="12" height="12"/>
					</td>
				</tr>
			</table>
		</CAPA>
	</xsl:template>

	<xsl:template match="ROWSET[@ID='DTOCargaCursos.parametros']">
		<xsl:for-each select="ROW">
		<xsl:variable name="oidActual">
		<xsl:choose>
			<xsl:when test="./CAMPO[@NOMBRE='OID_PARA']/text()='25'">
				<xsl:text>26</xsl:text>	
			</xsl:when>
			<xsl:when test="./CAMPO[@NOMBRE='OID_PARA']/text()='26'">
				<xsl:text>25</xsl:text>	
			</xsl:when>
            <xsl:otherwise>
				<xsl:value-of select="./CAMPO[@NOMBRE='OID_PARA']/text()"/>	
            </xsl:otherwise>		
		</xsl:choose>		
		</xsl:variable>
		<xsl:variable name="actual" select="parent::ROWSET/ROW[CAMPO[@NOMBRE='OID_PARA']/text()=$oidActual]"/>
		<xsl:copy-of select="$actual"/>
			<xsl:apply-templates select="$actual">
				<!-- Parámetro que se utilizará para formar el nombre de las etiquetas-->
				<xsl:with-param name="nombre">
					<xsl:choose>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='0'">Marca</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='1'">Canal</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='2'">TipoCurso</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='3'">NombreCurso</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='4'">ObjetivoCurso</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='5'">ContenidoCurso</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='6'">AccesoInformacion</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='7'">AccesoSeleccionDM</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='9'">FrecuenciaDictado</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='10'">FechaDisponible</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='11'">FechaLanzamiento</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='12'">FechaFin</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='13'">AlcanceGeografico</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='14'">SubgerenciaVentas</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='15'">Region</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='16'">Zona</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='17'">Seccion</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='18'">Territorio</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='19'">NOptimo</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='20'">TipoCliente</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='21'">Bloqueo</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='22'">Capacitador</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='23'">Relacion</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='24'">SubtipoCliente</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='25'">Clasificacion</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='26'">TipoClasificacion</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='27'">StatusCliente</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='28'">StatusCursosExigidos</xsl:when> 
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='29'">NOrdenes</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='30'">PeriodoInicio</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='31'">PeriodoFin</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='32'">Monto</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='33'">PeriodoInicioV</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='34'">PeriodoFinV</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='35'">PeriodoIngreso</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='36'">FechaIngreso</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='37'">NCondicion</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='38'">FechaUltimo</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='39'">ProductoEntregar</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='40'">NRegaloParticipantes</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='41'">MomentoEntregar</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='42'">CondicionPedido</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='43'">ControlMorosidad</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='44'">DescripcionD</xsl:when>
					</xsl:choose>				
				</xsl:with-param>
				<!-- Parámetro que se utilizará para almacenar el código del título de cada fieldset-->
				<xsl:with-param name="codigoLbl">
					<xsl:choose>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='0'">0069</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='1'">00217</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='2'">00218</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='3'">00219</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='4'">00220</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='5'">00221</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='6'">00222</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='7'">00225</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='9'">00227</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='10'">00228</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='11'">00229</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='12'">00230</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='13'">00262</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='14'">00231</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='15'">00232</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='16'">00233</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='17'">00234</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='18'">00235</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='19'">00236</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='20'">0068</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='21'">00237</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='22'">00238</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='23'">00239</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='24'">00240</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='25'">00241</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='26'">00242</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='27'">00243</xsl:when>
						<!--xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='28'">00244</xsl:when-->
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='28'">3059</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='29'">00245</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='30'">00246</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='31'">00247</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='32'">00248</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='33'">00249</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='34'">00250</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='35'">00251</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='36'">00252</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='37'">00253</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='38'">00254</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='39'">00255</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='40'">00256</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='41'">00257</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='42'">00258</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='43'">00259</xsl:when>
						<xsl:when test="$actual/CAMPO[@NOMBRE='OID_PARA']='44'">00260</xsl:when>
					</xsl:choose>				
				</xsl:with-param>				
				<!-- Parámetro que se utilizará para saber si es el último elemento-->
				<xsl:with-param name="ultimo" select="position()=last()"/>
 			</xsl:apply-templates>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="ROW">
		<!-- Parámetro que se utilizará para formar el nombre de las etiquetas-->
		<xsl:param name="nombre">No disponible</xsl:param>
		<!-- Parámetro que se utilizará para almacenar el código del título de cada fieldset-->
		<xsl:param name="codigoLbl">No disponible</xsl:param>
		<!-- Parámetro que se utilizará para saber si es el último elemento-->
		<xsl:param name="ultimo" select="false()"/>
		<table width="100%" border="0" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<IMG src="b.gif" width="8" height="8"/>
				</td>
				<td width="100%">
					<fieldset>
						<legend class="legend">
							<xsl:attribute name="style">padding-right:20px</xsl:attribute>
							<LABELC alto="13" filas="1" valor="" id="legend">
								<xsl:attribute name="nombre"><xsl:value-of select="concat('lbl',$nombre)"/></xsl:attribute>
								<xsl:attribute name="cod"><xsl:value-of select="$codigoLbl"/></xsl:attribute>
							</LABELC>
						</legend>
						<table width="100%" border="0" align="center" cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="3">
									<IMG src="b.gif" width="8" height="8"/>
								</td>
							</tr>
							<tr>
								<td>
									<IMG src="b.gif" width="8" height="8"/>
								</td>
								<td>
									<LABELC alto="17" filas="1" valor="" id="datosTitle" cod="1038">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('lblVisible',$nombre)"/></xsl:attribute>
									</LABELC>
								</td>
								<td>
									<IMG src="b.gif" width="25" height="8"/>
								</td>
								<td>
									<LABELC alto="17" filas="1" valor="" id="datosTitle" cod="949">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('lblObligatorio',$nombre)"/></xsl:attribute>
									</LABELC>
								</td>
								<td>
									<IMG src="b.gif" width="25" height="8"/>
								</td>
								<td>
									<LABELC alto="17" filas="1" valor="" id="datosTitle" cod="1553">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('lblValor',$nombre)"/></xsl:attribute>
									</LABELC>
								</td>
								<td>
									<IMG src="b.gif" width="25" height="8"/>
								</td>
								<td>
									<LABELC alto="17" filas="1" valor="" id="datosTitle" cod="914">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('lblModificable',$nombre)"/></xsl:attribute>
									</LABELC>
								</td>
								<td width="100%">
									<IMG src="b.gif" width="8" height="8"/>
								</td>
							</tr>
							<tr>
								<td>
									<IMG src="b.gif" width="8" height="8"/>
								</td>
								<td>
									<CHECKBOX id="datosCampos" check="S" readonly="N">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('Visible',$nombre)"/></xsl:attribute>
								        <xsl:choose>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='0' or ./CAMPO[@NOMBRE='OID_PARA']='1' or ./CAMPO[@NOMBRE='OID_PARA']='3' or ./CAMPO[@NOMBRE='OID_PARA']='6' or ./CAMPO[@NOMBRE='OID_PARA']='2'" > 
												<xsl:attribute name="readonly">S</xsl:attribute>
						                    </xsl:when> 
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='35'" > 
												<xsl:attribute name="onclick">onVisiblePeriodoIngreso('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='36'" > 
												<xsl:attribute name="onclick">onVisibleFechaIngreso('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='37'" > 
												<xsl:attribute name="onclick">onVisibleNCondicion('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='29'" > 
												<xsl:attribute name="onclick">onVisibleNOrdenes('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='30'" > 
												<xsl:attribute name="onclick">onVisiblePeriodoIniCons('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='31'" > 
												<xsl:attribute name="onclick">onVisiblePeriodoFinCons('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='32'" > 
												<xsl:attribute name="onclick">onVisibleMonto('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='33'" > 
												<xsl:attribute name="onclick">onVisiblePeriodoInicioV('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='34'" > 
												<xsl:attribute name="onclick">onVisiblePeriodoFinV('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:when>
						                    <xsl:otherwise>
												<xsl:attribute name="onclick">onVisible('<xsl:value-of select="concat('Visible',$nombre)"/>','<xsl:value-of select="concat('Obligatorio',$nombre)"/>','<xsl:value-of select="concat('Modificable',$nombre)"/>','<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
						                    </xsl:otherwise> 
										</xsl:choose>
										<xsl:if test="$ultimo">
											<xsl:attribute name="ontab">onTabUltimoVisible('<xsl:value-of select="$nombre"/>')</xsl:attribute>										
										</xsl:if>
									</CHECKBOX>
								</td>
								<td>
									<IMG src="b.gif" width="25" height="8"/>
								</td>
								<td>
									<CHECKBOX id="datosCampos" readonly="N">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('Obligatorio',$nombre)"/></xsl:attribute>
								        <xsl:if test = "./CAMPO[@NOMBRE='OID_PARA']='0' or ./CAMPO[@NOMBRE='OID_PARA']='1' or ./CAMPO[@NOMBRE='OID_PARA']='3' or ./CAMPO[@NOMBRE='OID_PARA']='6' or ./CAMPO[@NOMBRE='OID_PARA']='2'" > 
											<xsl:attribute name="readonly">S</xsl:attribute>
								        </xsl:if> 
						               <xsl:choose>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='35'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioPeriodoIngreso()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='36'" > 
												<xsl:attribute name="check">N</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioFechaIngreso()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='37'" > 
												<xsl:attribute name="check">N</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioNCondicion()</xsl:attribute>
						                    </xsl:when>
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='29'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioNOrdenes()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='30'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioPeriodoIniCons()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='31'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioPeriodoFinCons()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='32'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioMonto()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='33'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioPeriodoInicioV()</xsl:attribute>
						                    </xsl:when>
						                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='34'" > 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick">onObligatorioPeriodoFinV()</xsl:attribute>
						                    </xsl:when>
						                <xsl:otherwise> 
												<xsl:attribute name="check">S</xsl:attribute>
												<xsl:attribute name="onclick"></xsl:attribute>
											</xsl:otherwise>
						               </xsl:choose> 
									</CHECKBOX>
								</td>
								<td>
									<IMG src="b.gif" width="25" height="8"/>
								</td>
								<xsl:choose>
									<xsl:when test="./CAMPO[@NOMBRE='VAL_TIPO_PARA']='1'">
										<td nowrap="nowrap">
											<COMBO id="datosCampos" size="1" multiple="N" req="N" valorinicial="" textoinicial="" readonly="N">
													<xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre)"/></xsl:attribute>
									               <xsl:choose>
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='0'" > 
															<xsl:attribute name="onchange">onSeleccionaMarca()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when>
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='1'" > 
															<xsl:attribute name="onchange">onSeleccionaCanal()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when>
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='20'" > 
															<xsl:attribute name="onchange">onSeleccionaTipoCliente()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when>
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='24'" > 
															<xsl:attribute name="onchange">onSeleccionaSubtipoCliente()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='26'" > 
															<xsl:attribute name="onchange">onSeleccionaTipoClasificacion()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='14'" > 
															<xsl:attribute name="onchange">onSeleccionaSubgerencia()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='15'" > 
															<xsl:attribute name="onchange">onSeleccionaRegion()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='16'" > 
															<xsl:attribute name="onchange">onSeleccionaZona()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='17'" > 
															<xsl:attribute name="onchange">onSeleccionaSeccion()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='2'" > 
															<xsl:attribute name="onchange">onSeleccionaTipoCurso()</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
									                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='35'" >
															<xsl:attribute name="onchange">comprobarPeriodoIngreso('ValorPeriodoIngreso','ValorFechaIngreso','ValorNCondicion')</xsl:attribute>
															<ROWSET/>
									                    </xsl:when> 
										                <xsl:otherwise> 
															<ROWSET/>
														</xsl:otherwise>
									               </xsl:choose> 
											</COMBO>
										</td>
									</xsl:when>
									<xsl:when test="./CAMPO[@NOMBRE='VAL_TIPO_PARA']='2'">
										<td nowrap="nowrap">
											<TEXT id="datosCampos" max="30" tipo="" onchange="" size="30" valor="" req="N" validacion="" readonly="N">
												<xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre)"/></xsl:attribute>
												<xsl:if test="./CAMPO[@NOMBRE='VAL_TIPO_DATO']='Date'">
										        	<xsl:choose> 
										            	<xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='36'" > 
															<xsl:attribute name="onblur">validaFecha('<xsl:value-of select="concat('Valor',$nombre)"/>');comprobarFechaIngreso('ValorFechaIngreso','ValorPeriodoIngreso','ValorNCondicion')</xsl:attribute>
															<xsl:attribute name="max">10</xsl:attribute>
															<xsl:attribute name="size">12</xsl:attribute>
										                </xsl:when> 
										                <xsl:otherwise> 
															<xsl:attribute name="onblur">validaFecha('<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
															<xsl:attribute name="max">10</xsl:attribute>
															<xsl:attribute name="size">12</xsl:attribute>
										                </xsl:otherwise> 
													</xsl:choose>
												</xsl:if>
												<xsl:if test="./CAMPO[@NOMBRE='VAL_TIPO_DATO']='Integer'">
										        	<xsl:choose> 
										            	<xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='32'" > 
															<xsl:attribute name="onblur">validaMonto('<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
															<xsl:attribute name="max">16</xsl:attribute>
															<xsl:attribute name="size">21</xsl:attribute>
										                </xsl:when> 
										            	<xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='37'" > 
															<xsl:attribute name="onblur">validaEntero('<xsl:value-of select="concat('Valor',$nombre)"/>');comprobarNumeroPeriodos('ValorNCondicion','ValorPeriodoIngreso','ValorFechaIngreso')</xsl:attribute>
															<xsl:attribute name="max">2</xsl:attribute>
															<xsl:attribute name="size">2</xsl:attribute>
										                </xsl:when> 
										                <xsl:otherwise> 
															<xsl:attribute name="onblur">validaEntero('<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
															<xsl:attribute name="max">2</xsl:attribute>
															<xsl:attribute name="size">2</xsl:attribute>
										                </xsl:otherwise> 
													</xsl:choose>
												</xsl:if>
											</TEXT>
										</td>
									</xsl:when>
									<xsl:when test="./CAMPO[@NOMBRE='VAL_TIPO_PARA']='3'">
										<td>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td class="datosCampos">
														<RADIOB tipo="H" id="datosCampos" valor="" readonly="N">
															<xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre)"/></xsl:attribute>
											               <xsl:choose>
											                    <xsl:when test = "./CAMPO[@NOMBRE='OID_PARA']='13'" > 
																	<xsl:attribute name="onclick">onCambiaAlcance('<xsl:value-of select="concat('Valor',$nombre)"/>')</xsl:attribute>
																	<RBINPUT valor="S" check="N" onfocus="" id="datosCampos" cod="117"><xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre,'_S')"/></xsl:attribute>yy</RBINPUT>
																	<RBINPUT valor="N" check="S" onfocus="" id="datosCampos" cod="87"><xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre,'_N')"/></xsl:attribute>nn</RBINPUT>
																</xsl:when>
																<xsl:otherwise>
																	<RBINPUT valor="S" check="N" onfocus="" id="datosCampos" cod="117"><xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre,'_S')"/></xsl:attribute>yy</RBINPUT>
																	<RBINPUT valor="N" check="S" onfocus="" id="datosCampos" cod="87"><xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre,'_N')"/></xsl:attribute>nn</RBINPUT>
																</xsl:otherwise>
											               </xsl:choose>
														</RADIOB>
													</td>
												</tr>
											</table>
										</td>
									</xsl:when>
									<xsl:when test="./CAMPO[@NOMBRE='VAL_TIPO_PARA']='4'">
										<td nowrap="nowrap">
											<COMBO id="datosCampos" size="1" multiple="N" req="N" valorinicial="" textoinicial="" readonly="N">
												<xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre)"/></xsl:attribute>
												<ROWSET/>
											</COMBO>
										</td>
									</xsl:when>
									<xsl:when test="./CAMPO[@NOMBRE='VAL_TIPO_PARA']='5'">
										<td nowrap="nowrap">
											<COMBO id="datosCampos" size="5" multiple="S" req="N" valorinicial="" textoinicial="" readonly="N">
												<xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre)"/></xsl:attribute>
												<ROWSET/>
											</COMBO>
										</td>
									</xsl:when>
									<xsl:when test="./CAMPO[@NOMBRE='VAL_TIPO_PARA']='6'">
							            <td nowrap="nowrap">
							            	<AREATEXTO cols="50" id="datosCampos" msjreq="" readonly="N"  req="N" rows="3" tabindex="2" valor="">
												<xsl:attribute name="nombre"><xsl:value-of select="concat('Valor',$nombre)"/></xsl:attribute>
											</AREATEXTO>
							            </td>										
									</xsl:when>
								</xsl:choose>
								<td>
									<IMG src="b.gif" width="25" height="8"/>
								</td>
								<td>
									<CHECKBOX id="datosCampos" onclick="" check="S" readonly="N">
										<xsl:attribute name="nombre"><xsl:value-of select="concat('Modificable',$nombre)"/></xsl:attribute>
										<xsl:attribute name="onclick">onModificable('<xsl:value-of select="$nombre"/>')</xsl:attribute>
										<xsl:if test="$ultimo">
											<xsl:attribute name="ontab">focaliza(FORMULARIO+'.txtNombrePlantilla')</xsl:attribute>										
										</xsl:if>
									</CHECKBOX>
									<xsl:if test="$ultimo">
										<VAR nombre="nombreUltimo">
											<xsl:attribute name="valor"><xsl:value-of select="$nombre"/></xsl:attribute>
										</VAR>
									</xsl:if>
								</td>
								<td width="100%">
									<IMG src="b.gif" width="8" height="8"/>
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<IMG src="b.gif" width="8" height="8"/>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td>
					<IMG src="b.gif"/>
				</td>
			</tr>
			<tr>
				<td width="12" align="center">
					<IMG src="b.gif" width="12" height="15"/>
				</td>
				<td width="756">
					<IMG src="b.gif"/>
				</td>
				<td width="12">
					<IMG src="b.gif" width="12" height="1"/>
				</td>
			</tr>
		</table>
	</xsl:template>

</xsl:stylesheet>