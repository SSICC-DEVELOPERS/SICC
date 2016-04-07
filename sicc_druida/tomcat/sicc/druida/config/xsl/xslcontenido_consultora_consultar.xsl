<?xml version='1.0' encoding="ISO-8859-1"?>

<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:saxon="http://icl.com/saxon"       exclude-result-prefixes="saxon">
<xsl:output method="xml" indent="no" encoding="ISO-8859-1"/>

<xsl:variable name="ALTO_CAPA" select="300"/>

<xsl:template match="/"> 
<FORMULARIO nombre="f1">
	<xsl:apply-templates select="CONECTOR"/>
</FORMULARIO>
</xsl:template>

<xsl:template match="CONECTOR">
	<xsl:apply-templates select="ROWSET2"/>
</xsl:template>

<xsl:template match="ROWSET2">
	<xsl:apply-templates select="ROWSET[@ID='SOLICITUDES']/ROW" mode="GENERA_CAPAS">
         <xsl:sort select="CAMPO[@NOMBRE='SOLICITUD']"/>
	</xsl:apply-templates>
</xsl:template>

<xsl:template match="ROW" mode="GENERA_CAPAS">
	<xsl:variable name="posicion" select="position()"/>
	<xsl:variable name="y" select="15+(   (number($posicion)-1)  * (number($ALTO_CAPA)+15)    )"/>

        <CAPA nombre="CAPA{$posicion}" x="0px" y="{$y}px" ancho="600" alto="{$ALTO_CAPA}px" visibilidad="S" colorf="" imagenf="" repeat="" colborde="" padding="" z-index="" contravsb="" >

	<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td width="12"><IMG src="b.gif" width="12" height="12" /></td>

			<td class="tablaTitle" width="50"><LABELC nombre="lblTituloSolicitud" ancho="50" alto="30" filas="1" id="datosTitleLeft" cod="850" valor="" enviaroculto="N"/>
			</td>			
			<td class="tablaTitle" width="8"><IMG src="b.gif" width="8" height="8" /></td>		
			<td class="tablaTitle" width="100"><LABELC nombre="lblSolicitud" ancho="100" alto="24" filas="1" id="datosCamposLeft" valor="{CAMPO[@NOMBRE='SOLICITUD']}" />			
			</td>	
			<td class="tablaTitle" width="1"><IMG src="b.gif" width="1" height="8" /></td>
			<td class="tablaTitle" width="115"><IMG src="b.gif" width="1" height="8" /></td>
			<td class="tablaTitle" width="1"><IMG src="b.gif" width="1" height="8" /></td>
			<td class="tablaTitle"><IMG src="b.gif" width="1" height="8" /></td>	
			
			<td width="12"><IMG src="b.gif" width="12" height="12" /></td>
		</tr>
	</table>


	<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td width="12"><IMG src="b.gif" width="12" height="12" /></td>
			<td width="70">
			<LABELC nombre="lblTituloNumero" ancho="70" alto="30" 
			filas="1" id="datosTitleRight" cod="869" valor="" enviaroculto="N"/>	
			</td>
			<td width="8" align="center"><IMG src="b.gif" width="8" height="8" /></td>
			<td width="150">
			<LABELC nombre="lblNumero" ancho="150" alto="24" 
			filas="1" id="datosCamposLeft" valor="{CAMPO[@NOMBRE='NUMERO']}" />
			</td>	
			<td width="8" align="center"><IMG src="b.gif" width="8" height="8" /></td>		
			<td width="115">
			<LABELC nombre="lblTituloFecha" ancho="115" alto="30" 
			filas="1" id="datosTitleRight" cod="591" valor="" enviaroculto="N"/>	
			</td>
			<td width="8" align="center"><IMG src="b.gif" width="8" height="8" /></td>
			<td width="150">
			<LABELC nombre="lblFecha" ancho="150" alto="24" 
			filas="1" id="datosCamposLeft" valor="{CAMPO[@NOMBRE='FECHA']}" />
			</td>
			<td width="48"><IMG src="b.gif" width="48" height="12" /></td>
		</tr>

		<tr>
			<td width="12"><IMG src="b.gif" width="12" height="12" /></td>
			<td width="70">
			<LABELC nombre="lblTituloMontoTotal" ancho="70" alto="30" 
			filas="1" id="datosTitleRight" cod="592" valor="" enviaroculto="N"/>	
			</td>
			<td width="8" align="center"><IMG src="b.gif" width="8" height="8" /></td>
			<td width="150">
			<LABELC nombre="lblMontoTotal" ancho="150" alto="24" 
			filas="1" id="datosCamposLeft" valor="{CAMPO[@NOMBRE='MONTO_TOTAL']}" />
			</td>
			<td width="8" align="center"><IMG src="b.gif" width="8" height="8" /></td>	
			<td width="115">
			<LABELC nombre="lblTituloDescuentoTotal" ancho="115" alto="30" 
			filas="1" id="datosTitleRight" cod="870" valor="" enviaroculto="N"/>	
			</td>
			<td width="8" align="center"><IMG src="b.gif" width="8" height="8" /></td>
			<td width="150">
			<LABELC nombre="lblDescuentoTotal" ancho="150" alto="24" 
			filas="1" id="datosCamposLeft" valor="{CAMPO[@NOMBRE='DESCUENTO_TOTAL']}" />
			</td>
			<td width="48"><IMG src="b.gif" width="48" height="12" /></td>
		</tr>					
	</table>
         
        <LISTA seleccion="boton" nombre="Clientes" x="12" y="120" ancho="580" alto="150" colorf="#EFEFEF" multisel="0" incy="10" incx="10" imagenon="close_up.gif" imagenoff="close_no.gif" sep="|" pixelsborde="3" colorborde="#CCCCCC" accion="">

	<CABECERA nombre="cab1" height="20" ancho="850" >
		<COL id="fondoCabecera" ancho="70"><LABELC nombre="cabecera1" ancho="70" alto="20" filas="1" id="datosCamposCabecera" cod="43" valor="" enviaroculto="N"/></COL>
		<COL id="fondoCabecera" ancho="100"><LABELC nombre="cabecera2" ancho="100" alto="20" filas="1" id="datosCamposCabecera" cod="28" valor="" enviaroculto="N"/></COL> 
		<COL id="fondoCabecera" ancho="80"><LABELC nombre="cabecera3" ancho="80" alto="20" filas="1" id="datosCamposCabecera" cod="796" valor="" enviaroculto="N"/></COL>  
		<COL id="fondoCabecera" ancho="120"><LABELC nombre="cabecera4" ancho="120" alto="20" filas="1" id="datosCamposCabecera" cod="892" valor="" enviaroculto="N"/></COL>
		<COL id="fondoCabecera" ancho="110"><LABELC nombre="cabecera5" ancho="110" alto="20" filas="1" id="datosCamposCabecera" cod="893" valor="" enviaroculto="N"/></COL>  
		<COL id="fondoCabecera" ancho="130"><LABELC nombre="cabecera6" ancho="130" alto="20" filas="1" id="datosCamposCabecera" cod="894" valor="" enviaroculto="N"/></COL>
		<COL id="fondoCabecera" ancho="100"><LABELC nombre="cabecera7" ancho="100" alto="20" filas="1" id="datosCamposCabecera" cod="895" valor="" enviaroculto="N"/></COL>
		<COL id="fondoCabecera"	ancho="130"><LABELC nombre="cabecera8" ancho="130" alto="20" filas="1" id="datosCamposCabecera" cod="896" valor="" enviaroculto="N"/></COL>
		<COL id="fondoCabecera"	ancho="30"></COL>
	</CABECERA>
      
	<PRESENTACION ancho="840" filas="1" bloquesid="['datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar', 'datosCamposCenterImpar', 'datosCamposCenterPar']">
		<COL ancho="70"  caracteres="70"/>
		<COL ancho="100"  caracteres="100"/>
		<COL ancho="80"  caracteres="80"/>            
		<COL ancho="120" caracteres="120"/>    
		<COL ancho="110" caracteres="110"/>    
		<COL ancho="130" caracteres="130"/>    
		<COL ancho="100" caracteres="100"/>
		<COL ancho="130" caracteres="130"/>    
	</PRESENTACION>

       <ROWSET>
		<xsl:apply-templates select="//ROWSET2/ROWSET[@ID='DATOS']/ROW" mode="crea_row"/>
       </ROWSET>
       </LISTA>

       </CAPA>
		</xsl:template>
   
<xsl:template match="ROW" mode="crea_row">
	<xsl:copy-of select="."/>
</xsl:template>

</xsl:transform>