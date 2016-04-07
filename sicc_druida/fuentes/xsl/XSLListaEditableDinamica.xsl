<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes" version="1.0"/>
	<xsl:param name="nombre">listado1</xsl:param>
	<xsl:param name="columnas">4</xsl:param>
	<xsl:param name="esPaginado">1</xsl:param>
	<xsl:param name="nombrePaginado">mipgndo1</xsl:param>
	<xsl:param name="filas">10</xsl:param>
	<xsl:template match="/">
		<LISTAEDITABLE nombre="{$nombre}" ancho="800" alto="346" x="12" y="52" colorFondo="#CECFCE" msgDebugJS="S">
	      <IMGBOTONES precarga="S" conROver="S">
	        <BTNSELECCION normal="btnLista2N.gif" rollOver="btnLista2S.gif" seleccionado="btnLista2M.gif" desactivado="btnLista2D.gif" /> 
	        <BTNMINIMIZAR minimizar="bot_pliega_columna_on.gif" minimROver="bot_pliega_columna_over.gif" maximizar="bot_despliega_columna_on.gif" maximROver="bot_despliega_columna_over.gif" /> 
	      </IMGBOTONES>
	      <LINEAS>
	        <GROSOR borde="1" horizDatos="1" horizCabecera="1" vertical="0"/> 
	        <COLOR borde="#999999" vertCabecera="#999999" vertDatos="#999999" horizDatos="#999999" horizCabecera="#999999" /> 
	      </LINEAS>
	      <COLUMNAS ajustarMinimo="S" permiteOrdenar="S" blancosAInsertar="1" sinSaltoLinea="S" AnchoMinimizadas="20">
			<xsl:call-template name="generaColumnas"/>
	      </COLUMNAS>
	      <CABECERA alto="20" IDScroll="EstCab" imgFondo="" colFondo="#CCCCCC">
            <xsl:call-template name="generaColumnasCabecera"/>
	      </CABECERA>
	      <DATOS alto="22" accion="" tipoEnvio="edicion" formaEnvio="xml" maxSel="-1" msgErrMaxSel="" colorROver="#D0D9E8"
	             coloresScrollNativo="#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" 
	             onLoad="" colorSelecc="#D0D9E8">
					 <xsl:call-template name="generaColumnasDatos"/>
	      </DATOS>
	      <ROWSET>
	      		<xsl:call-template name="generaFilas"/>
	      </ROWSET>
	      <xsl:if test="number($esPaginado) = 1">
		    <PAGINADO nombre="{$nombrePaginado}" ancho="240" sep="$" x="12" class="botonera" y="350" control="|" conector="conector_textarea" rowset="" cargainicial="N">
		        <BOTON x="250" y="350" ID="botonContenido" img="primera_on" tipo="0" estado="false" alt="" codigo="" accion="mipgndo.retrocederPrimeraPagina();" > 
						<xsl:attribute name="nombre"><xsl:value-of select="$nombre"/><xsl:text>_pri1</xsl:text></xsl:attribute> 
				  </BOTON>
		        <BOTON x="267" y="350" ID="botonContenido" img="retroceder_on" tipo="0" estado="false" alt="" codigo="" accion="mipgndo.retroceder();" > 
						<xsl:attribute name="nombre"><xsl:value-of select="$nombre"/><xsl:text>_ret1</xsl:text></xsl:attribute> 
				  </BOTON>
		        <BOTON x="282" y="350" ID="botonContenido" img="avanzar_on" tipo="0" estado="false" alt="" codigo="" accion="mipgndo.avanzar();" > 
						<xsl:attribute name="nombre"><xsl:value-of select="$nombre"/><xsl:text>_ava1</xsl:text></xsl:attribute> 
				  </BOTON>
		    </PAGINADO>
	    </xsl:if>
	    </LISTAEDITABLE>
	</xsl:template>
	
	<xsl:template name="generaColumnas">
		<xsl:param name="contador">0</xsl:param>
		<xsl:if test="number($columnas) - number($contador) > 0">
			<COL ancho="200" minimizable="S" minimizada="N"/>
			<xsl:call-template name="generaColumnas">
				<xsl:with-param name="contador">
					<xsl:value-of select="number($contador)+1"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="generaColumnasCabecera">
		<xsl:param name="contador">0</xsl:param>
		<xsl:if test="number($columnas) - number($contador) > 0">
			<COL colFondo="" ID="EstCab" align="center" cod=""/>
			<xsl:call-template name="generaColumnasCabecera">
				<xsl:with-param name="contador">
					<xsl:value-of select="number($contador)+1"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="generaColumnasDatos">
		<xsl:param name="contador">0</xsl:param>
		<xsl:if test="number($columnas) - number($contador) > 0">
			<COL tipo="texto"> 
					<xsl:attribute name="ID">
					<xsl:choose>
					  <xsl:when test="number($contador mod 2) = 0 ">
						<xsl:text>EstDat</xsl:text>
					  </xsl:when>
					  <xsl:otherwise>
						<xsl:text>EstDat2</xsl:text>
					  </xsl:otherwise>
					</xsl:choose> 					
				</xsl:attribute> 
			</COL>
			<xsl:call-template name="generaColumnasDatos">
				<xsl:with-param name="contador">
					<xsl:value-of select="number($contador)+1"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>


	<xsl:template name="generaFilas">
		<xsl:param name="contador">0</xsl:param>
		<xsl:if test="number($filas) - number($contador) > 0">
			<ROW ID="{number($contador)+1}">
				<CAMPO NOMBRE="dato1" TIPO="STRING" VALOR="COD{number($contador)+1}" /> 
				<xsl:call-template name="generaCampos"/>
			</ROW>
			<xsl:call-template name="generaFilas">
				<xsl:with-param name="contador">
					<xsl:value-of select="number($contador)+1"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>

	<xsl:template name="generaCampos">
		<xsl:param name="contador">1</xsl:param>
		<xsl:if test="number($columnas) - number($contador) > 0">
			<CAMPO NOMBRE="dato{number($contador)+1}" TIPO="STRING" VALOR="" /> 
			<xsl:call-template name="generaCampos">
				<xsl:with-param name="contador">
					<xsl:value-of select="number($contador)+1"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>