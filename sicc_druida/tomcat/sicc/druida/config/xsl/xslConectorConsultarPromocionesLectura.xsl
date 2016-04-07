<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>

<xsl:key name="condiciones" match="ROW" use="CAMPO[@NOMBRE='NUM_COND'][position()=1]"/>

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
	  <table width="582" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCCC">
          <tr>            
	    <td class="tablaTitle">
	       <LABELC nombre="lblCondi" alto="25" ancho="100" filas="1" id = "datosCamposCabecera"  cod="644"/>
 	    </td>
          </tr>
          <tr> 
            <td>		  
	       <xsl:apply-templates select="//ROWSET[@ID='dtoSalida.condiciones_ROWSET']"></xsl:apply-templates>		  		 		
	    </td>
	  </tr>         
	  </table>
      </td>
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
    </tr>   
  </table>		
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:for-each select="ROW[count(. | key('condiciones',CAMPO[@NOMBRE='NUM_COND'])[1])=1]">
	<xsl:sort select="CAMPO[@NOMBRE='NUM_COND']"/>
		<!--
		ak se arma el header de las tablas, es decir, el agrupado
		-->
	  <table width="98%" border="1" cellspacing="1" cellpadding="0" align="center" bordercolor="#CCCCCC">
           <tr>
           <td>
              <table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">   
		<tr>
		   <td colspan="3" class="datosCampos"><IMG src="b.gif" width="8" height="8"/></td>
		</tr>
		<tr>
		  <td width="133px">
		    <LABELC nombre="lblNumCond_{CAMPO[@NOMBRE='NUM_COND']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="640"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		    <xsl:value-of select="CAMPO[@NOMBRE='NUM_COND']"></xsl:value-of>
		  </td>
		</tr>
		<tr>
		  <td width="133px">
		   <LABELC nombre="lblIndCuadre_{CAMPO[@NOMBRE='NUM_COND']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="184"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		    <xsl:value-of select="CAMPO[@NOMBRE='DES_IND_CUAD']"></xsl:value-of>
		  </td>
		</tr>
		<tr>
		  <td width="133px">
		    <LABELC nombre="lblFactCuadre_{CAMPO[@NOMBRE='NUM_COND']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="183"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		    <xsl:value-of select="CAMPO[@NOMBRE='COD_FACT_CUAD']"></xsl:value-of>
		  </td>					
		</tr>
		<tr>
		  <td colspan="3" class="datosCampos"><IMG src="b.gif" width="8" height="8"/></td>
		</tr>
		<xsl:apply-templates select="." ></xsl:apply-templates>		
                </table>
           </td>
	   </tr>	  
           <tr>
	   <td class="datosCampos" style="border:none"><IMG src="b.gif" width="8" height="8"/></td>
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
	<td height="151" colspan="3" valign="top">
	<LISTA seleccion="boton" nombre="lstCondicion_{CAMPO[@NOMBRE='NUM_COND']}"  
	        ancho="547" alto="150"	entradax = "" entraday = "" x="" y=""
		colorf = "#EFEFEF" oncolor = "" chkcolor = "" visibilidad = ""
		incx = "10" incy = "10" nmin = "" nmax = "-1" multisel = "0" accion=""
		sep = "|" imagenon = "close_up.gif" imagenoff = "close_no.gif" 
		pixelsborde = "2" colorborde = "#CCCCCC"  onSetDatos = "" blockImg = "">			
	  <CABECERA nombre = "cab1" height = "30">	    
	    <COL id = "fondoCabecera" ancho = "310"><LABELC nombre = "lblCatalogo_{CAMPO[@NOMBRE='NUM_COND']}" ancho = "310" alto = "30" filas = "1" 	
		id = "datosCamposCabecera" cod = "453" valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "130"><LABELC nombre = "lblTipoCond_{CAMPO[@NOMBRE='NUM_COND']}" ancho = "130"	alto = "30" 
		filas = "1"	id = "datosCamposCabecera" cod = "641" valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "310"><LABELC nombre = "lblDesde_{CAMPO[@NOMBRE='NUM_COND']}" ancho = "310" alto = "30" filas = "1"
		id = "datosCamposCabecera" cod = "642"	valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "310"><LABELC nombre = "lblHasta_{CAMPO[@NOMBRE='NUM_COND']}"	ancho = "310" alto = "30" 
		filas = "1" id = "datosCamposCabecera" cod = "347"	valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "70"><LABELC nombre = "lblExclusion_{CAMPO[@NOMBRE='NUM_COND']}" 	ancho = "70" alto = "30" filas = "1" 
		id = "datosCamposCabecera" cod = "643"	valor = "" enviaroculto = "N"/></COL>	 
	    <COL id = "fondoCabecera" ancho = "20"></COL>	
	  </CABECERA>

	  <PRESENTACION ancho = "1130" filas = "1"	bloquesid = "['datosCamposCenterImpar',	'datosCamposCenterPar',
									'datosCamposCenterImpar','datosCamposCenterPar',
									'datosCamposCenterImpar']">				    
	    <COL ancho = "310" caracteres = "50"/>
	    <COL ancho = "130" caracteres = "50"/>
	    <COL ancho = "310" caracteres = "50"/>
	    <COL ancho = "310" caracteres = "50"/>
	    <COL ancho = "70" caracteres = "50"/>	  
	  </PRESENTACION>
			
	  <ROWSET>
					
	  <xsl:for-each select="key('condiciones', CAMPO[@NOMBRE='NUM_COND'])">
	  <xsl:sort select="CAMPO[@NOMBRE='DES_CATA']" />
                <ROW>		      
		    <xsl:copy-of select="CAMPO[position()=6]"/>
		    <xsl:copy-of select="CAMPO[position()=8]"/>
		    <xsl:copy-of select="CAMPO[position()=9]"/>
		    <xsl:copy-of select="CAMPO[position()=10]"/>
		    <CAMPO NOBRE="concatenados" TIPO="STRING">
			<xsl:choose>
		     <xsl:when test="CAMPO[@NOMBRE='IND_EXCL']=1">
			Si
		     </xsl:when>
		     <xsl:when test="CAMPO[@NOMBRE='IND_EXCL']=0">
			No
		     </xsl:when>		    
 		     </xsl:choose>
		    </CAMPO>		    
		</ROW>

				
	  </xsl:for-each>
          </ROWSET>
        </LISTA>
        </td>
      </tr>     
</xsl:template>


</xsl:stylesheet>