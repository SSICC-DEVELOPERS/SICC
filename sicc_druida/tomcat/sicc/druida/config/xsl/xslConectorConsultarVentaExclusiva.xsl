<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>

<xsl:template match="//ROWSET2">
  <table width="597" border="0" cellspacing="0" cellpadding="0"  align="center">
    <tr> 
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
    </tr>
    <tr>      
      <td width="10" align="center"><IMG src="b.gif" width="10" height="12"/></td>
      <td>
	  <table width="582" border="0" cellspacing="0" cellpadding="0" bordercolor="#CCCCCC">         
          <tr> 
            <td>		  
	       <xsl:apply-templates select="//ROWSET[@ID='dtoSalida.ventaExclusiva_ROWSET']"></xsl:apply-templates>		  		 		
	    </td>
	  </tr>          
	  </table>
      </td>
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
    </tr>       
  </table>		
</xsl:template>

<xsl:template match="ROWSET">	
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" bordercolor="#CCCCCC">      
	        <tr>            
	         <td width="100%" class="tablaTitle">
	          <LABELC nombre="lblVentaExclusiva" alto="25" ancho="180" filas="1" id = "datosCamposCabecera"  cod="455"/>
 	         </td>
                </tr>
		<tr>
	        <td height="150"  valign="top">
	        <LISTA seleccion="boton" nombre="lstVentaExlusiva"  
			ancho="582" alto="150"	entradax = "" entraday = "" x="" y=""
			colorf = "#EFEFEF" oncolor = "" chkcolor = "" visibilidad = ""
			incx = "10" incy = "10" nmin = "" nmax = "-1" multisel = "-1" accion=""
			sep = "|" imagenon = "close_up.gif" imagenoff = "close_no.gif" 
			pixelsborde = "2" colorborde = "#CCCCCC"  onSetDatos = "" blockImg = "">			
		<CABECERA nombre = "cab1" height = "30">
			<COL id = "fondoCabecera" ancho = "20"></COL>
			<COL id = "fondoCabecera" ancho = "260"><LABELC nombre = "lblTipoCliente" ancho = "260" alto = "30" filas = "1" 	
			id = "datosCamposCabecera" cod = "267" valor = "" enviaroculto = "N"/></COL>
			<COL id = "fondoCabecera" ancho = "260"><LABELC nombre = "lblSubtipoCliente" ancho = "260"	alto = "30" 
			filas = "1"	id = "datosCamposCabecera" cod = "273" valor = "" enviaroculto = "N"/></COL>
			<COL id = "fondoCabecera" ancho = "310"><LABELC nombre = "lblTipoClasificacion" ancho = "310" alto = "30" filas = "1"
			id = "datosCamposCabecera" cod = "782"	valor = "" enviaroculto = "N"/></COL>
			<COL id = "fondoCabecera" ancho = "310"><LABELC nombre = "lblClasificacion" ancho = "310" alto = "30" filas = "1"
			id = "datosCamposCabecera" cod = "654"	valor = "" enviaroculto = "N"/></COL>
			<COL id = "fondoCabecera" ancho = "260"><LABELC nombre = "lblEstatus"	ancho = "260" alto = "30" 
			filas = "1" id = "datosCamposCabecera" cod = "373"	valor = "" enviaroculto = "N"/></COL>
			<COL id = "fondoCabecera" ancho = "100"><LABELC nombre = "lblEstatus2" 	ancho = "100" alto = "30" filas = "1" 
			id = "datosCamposCabecera" cod = "459"	valor = "" enviaroculto = "N"/></COL>	 
			<COL id = "fondoCabecera" ancho = "20"></COL>	
		</CABECERA>

		<PRESENTACION ancho = "1520" filas = "1"	bloquesid = "['datosCamposCenterImpar',	'datosCamposCenterPar','datosCamposCenterImpar','datosCamposCenterPar','datosCamposCenterImpar','datosCamposCenterPar']">			
			<COL ancho = "20" caracteres = "5"/>
			<COL ancho = "260" caracteres = "50"/>
			<COL ancho = "260" caracteres = "50"/>
			<COL ancho = "310" caracteres = "50"/>
			<COL ancho = "310" caracteres = "50"/>
			<COL ancho = "260" caracteres = "50"/>
			<COL ancho = "100" caracteres = "50"/>	  
		</PRESENTACION>
			
		<ROWSET>
		
		<xsl:apply-templates select="./ROW" ></xsl:apply-templates>

		</ROWSET>
		</LISTA>
		</td>
		</tr>			
		<tr>
	        <td  width="100%" class="tablaTitle">
		   <BOTON nombre="btnAniadirVent" tipo="html" accion="javascript:aniadirVentaExclusiva();"  ID="botonContenido"
                    estado="false"  cod="221"/>
	           <BOTON nombre="btnEliminarVent" tipo="html" accion="javascript:eliminarVentaExclusiva();"  ID="botonContenido"
                    estado="false"  cod="143"/>
	        </td>
	        </tr>
	   </table>
</xsl:template>

<xsl:template match="ROW">        	
	  
                <ROW>
		    <CAMPO NOBRE="concatenados" TIPO="STRING">
			<xsl:value-of select="CAMPO[position()=9]"/>--<xsl:value-of select="CAMPO[position()=10]"/>--<xsl:value-of select="CAMPO[position()=7]"/>--<xsl:value-of select="CAMPO[position()=8]"/>--<xsl:value-of select="CAMPO[position()=13]"/>
		    </CAMPO>	  	    
		    <xsl:copy-of select="CAMPO[position()=1]"/>
		    <xsl:copy-of select="CAMPO[position()=2]"/>
		    <xsl:copy-of select="CAMPO[position()=3]"/>
		    <xsl:copy-of select="CAMPO[position()=4]"/>
		    <xsl:copy-of select="CAMPO[position()=5]"/>
		    <xsl:copy-of select="CAMPO[position()=6]"/>		    
		</ROW>

                
</xsl:template>


</xsl:stylesheet>